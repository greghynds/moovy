package com.github.grehynds.moovy

import android.app.Application
import com.github.grehynds.moovy.arch.di.asyncModule
import com.github.grehynds.moovy.arch.di.networkModule
import com.github.grehynds.moovy.arch.di.serializationModule
import com.github.grehynds.moovy.home.di.homeModule
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