package com.github.greghynds.moovy.arch.presentation

import android.util.Log
import com.github.greghynds.redux.Middleware
import com.github.grehynds.redux.fsa.Action

fun <State> createLoggingMiddleware(): Middleware<State> = {
    { action ->
        if (action is Action) {
            var text = "Dispatching: ${action.type}"
            if (action?.payload is Throwable) text += ", Error: ${(action.payload as Throwable).message}"
            Log.d("Redux", text)
        }
        action
    }
}

fun <State> createThunkMiddleware(): Middleware<State> = { store ->
    { action ->
        if (action is Thunk<*>) {
            Log.d("Redux", "Received thunk!")
            (action as Thunk<State>).createAction(store)
        } else {
            action
        }
    }
}