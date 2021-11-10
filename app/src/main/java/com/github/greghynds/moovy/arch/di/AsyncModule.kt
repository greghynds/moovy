package com.github.greghynds.moovy.arch.di

import com.github.greghynds.moovy.arch.async.AndroidDispatchers
import com.github.greghynds.moovy.arch.async.Dispatchers
import org.koin.dsl.module

val asyncModule = module {
    single<Dispatchers> { AndroidDispatchers }
}