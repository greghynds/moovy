package com.github.greghynds.moovy.app

import android.app.Application
import com.github.greghynds.moovy.app.di.Dependencies
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(Dependencies.all)
            androidContext(this@App)
        }
    }
}