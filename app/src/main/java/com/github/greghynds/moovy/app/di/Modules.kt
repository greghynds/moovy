package com.github.greghynds.moovy.app.di

import com.github.greghynds.moovy.arch.di.asyncModule
import com.github.greghynds.moovy.arch.di.networkModule
import com.github.greghynds.moovy.arch.di.serializationModule
import com.github.greghynds.moovy.arch.di.storageModule
import com.github.greghynds.moovy.home.di.homeModule


object Dependencies {

    val all = listOf(
        asyncModule,
        serializationModule,
        networkModule,
        storageModule,
        appModule,
        homeModule,
        stateModule
    )
}