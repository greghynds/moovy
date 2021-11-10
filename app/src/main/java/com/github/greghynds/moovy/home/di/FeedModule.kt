package com.github.greghynds.moovy.home.di

import com.github.greghynds.moovy.arch.data.createApiClient
import com.github.greghynds.moovy.home.data.ComingSoonApi
import com.github.greghynds.moovy.home.data.ComingSoonClient
import com.github.greghynds.moovy.home.domain.GetComingSoon
import com.github.greghynds.moovy.home.domain.MoviesRepo
import org.koin.dsl.module

val homeModule = module {
    single<ComingSoonClient> { createApiClient(get()) }
    single<MoviesRepo> { ComingSoonApi(get()) }
    single { GetComingSoon(get()) }
}