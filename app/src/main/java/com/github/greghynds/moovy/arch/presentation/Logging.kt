package com.github.greghynds.moovy.arch.presentation

import android.util.Log
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.redux.Middleware

fun createLoggingMiddleware(): Middleware<AppState> = {
    { action ->
        var text = "Dispatching: ${action.type}"
        if (action.payload is Throwable) text += ", Error: ${(action.payload as Throwable).message}"
        Log.d("Redux", text)
        action
    }
}