package com.github.grehynds.moovy.arch.async

import kotlinx.coroutines.CoroutineDispatcher

interface Dispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
}