package com.github.greghynds.moovy.arch.di

import com.github.greghynds.moovy.BuildConfig
import com.github.greghynds.moovy.arch.data.ClientConfig
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