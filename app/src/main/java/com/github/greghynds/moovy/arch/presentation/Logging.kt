package com.github.greghynds.moovy.arch.presentation

import android.util.Log
import com.github.greghynds.redux.Middleware
import com.github.greghynds.moovy.AppState

fun createLoggingMiddleware(): Middleware<AppState> = {
    { action ->
        val text = "Dispatching: ${action.type}" +  if(action.payload is Throwable) ", Error: ${(action.payload as Throwable).message}" else ""
        Log.d("Redux", text)
        action
    }
}