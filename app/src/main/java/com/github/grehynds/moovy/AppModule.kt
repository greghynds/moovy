package com.github.grehynds.moovy

import com.github.greghynds.redux.createStore
import com.github.grehynds.moovy.arch.presentation.createLoggingMiddleware
import com.github.grehynds.moovy.home.presentation.createGetComingSoonThunk
import org.koin.dsl.module

val appModule = module {
    single {
        createStore(
            rootReducer,
            AppState.INITIAL,
            createLoggingMiddleware(),
            createGetComingSoonThunk(get(), get())
        )
    }
}