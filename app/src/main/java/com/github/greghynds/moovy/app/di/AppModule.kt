package com.github.greghynds.moovy.app.di

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.presentation.createSaveAppStateMiddleware
import com.github.greghynds.moovy.app.rootReducer
import com.github.greghynds.moovy.arch.presentation.createLoggingMiddleware
import com.github.greghynds.moovy.arch.presentation.createThunkMiddleware
import com.github.greghynds.redux.createStore
import org.koin.dsl.module

val appModule = module {
    single {
        createStore(
            rootReducer,
            AppState.INITIAL,
            createLoggingMiddleware(),
            createThunkMiddleware(),
            createSaveAppStateMiddleware(get(), get()),
        )
    }
}