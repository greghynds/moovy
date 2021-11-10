package com.github.greghynds.moovy.arch.async

import kotlinx.coroutines.CoroutineDispatcher

object AndroidDispatchers : Dispatchers {
    override val io: CoroutineDispatcher get() = kotlinx.coroutines.Dispatchers.IO
    override val main: CoroutineDispatcher get() = kotlinx.coroutines.Dispatchers.Main
}