package com.github.greghynds.moovy.arch.presentation

object Display : ScreenState()
object Loading : ScreenState()
class Error(val error: Throwable) : ScreenState()

open class ScreenState