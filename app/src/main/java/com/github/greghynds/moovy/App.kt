package com.github.greghynds.moovy

import android.app.Application
import com.github.greghynds.moovy.arch.di.asyncModule
import com.github.greghynds.moovy.arch.di.networkModule
import com.github.greghynds.moovy.arch.di.serializationModule
import com.github.greghynds.moovy.home.di.homeModule
import org.koin.core.context.startKoin

class App : Application() {

    private val modules = listOf(
        asyncModule,
        serializationModule,
        networkModule,
        appModule,
        homeModule
    )

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(modules)
        }
    }
}