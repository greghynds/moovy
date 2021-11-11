package com.github.greghynds.moovy.app.di

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.rootReducer
import com.github.greghynds.moovy.arch.presentation.createLoggingMiddleware
import com.github.greghynds.moovy.home.presentation.createGetComingSoonThunk
import com.github.greghynds.redux.createStore
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
