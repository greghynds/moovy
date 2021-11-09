package com.github.grehynds.moovy.arch.middleware

import android.util.Log
import com.github.greghynds.redux.Middleware
import com.github.grehynds.moovy.AppState

fun createLoggingMiddleware(): Middleware<AppState> = {
    { action ->
        Log.d("Redux", "Dispatching: ${action.type}")
        action
    }
}