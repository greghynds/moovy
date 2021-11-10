package com.github.greghynds.moovy

import com.github.greghynds.redux.createStore
import com.github.greghynds.moovy.arch.presentation.createLoggingMiddleware
import com.github.greghynds.moovy.home.presentation.createGetComingSoonThunk
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