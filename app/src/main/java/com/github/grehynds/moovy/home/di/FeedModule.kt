package com.github.grehynds.moovy.home.di

import com.github.grehynds.moovy.arch.data.createApiClient
import com.github.grehynds.moovy.home.data.ComingSoonApi
import com.github.grehynds.moovy.home.data.ComingSoonClient
import com.github.grehynds.moovy.home.domain.GetComingSoon
import com.github.grehynds.moovy.home.domain.MoviesRepo
import org.koin.dsl.module

val homeModule = module {
    single<ComingSoonClient> { createApiClient(get()) }
    single<MoviesRepo> { ComingSoonApi(get()) }
    single { GetComingSoon(get()) }
}