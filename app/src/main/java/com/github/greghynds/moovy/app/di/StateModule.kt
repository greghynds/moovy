package com.github.greghynds.moovy.app.di

import com.github.greghynds.moovy.app.domain.LoadAppState
import com.github.greghynds.moovy.app.domain.SaveAppState
import org.koin.dsl.module

val stateModule = module {
    single { LoadAppState(get(), get()) }
    single { SaveAppState(get(), get()) }
}
