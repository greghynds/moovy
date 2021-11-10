package com.github.grehynds.moovy.arch.di

import com.github.grehynds.moovy.BuildConfig
import com.github.grehynds.moovy.arch.data.ClientConfig
import org.koin.dsl.module


val networkModule = module {
    single {
        ClientConfig(
            "https://imdb-api.com/en/API/",
            get(),
            loggingEnabled = BuildConfig.DEBUG
        )
    }
}