package com.github.grehynds.moovy.arch.di

import com.github.grehynds.moovy.arch.async.AndroidDispatchers
import com.github.grehynds.moovy.arch.async.Dispatchers
import org.koin.dsl.module

val asyncModule = module {
    single<Dispatchers> { AndroidDispatchers }
}