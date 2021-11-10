package com.github.grehynds.moovy.arch.di

import com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
import com.fasterxml.jackson.databind.ObjectMapper
import org.koin.dsl.module

val serializationModule = module {
    val mapper = ObjectMapper().apply {
        configure(FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    single { mapper }
}