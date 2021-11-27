package com.github.greghynds.moovy.arch.di

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val storageModule = module {
    single<SharedPreferences> { androidContext().getSharedPreferences(NAMESPACE_SHARED_PREFS, MODE_PRIVATE) }
}

private const val NAMESPACE_SHARED_PREFS = "moovy_app"