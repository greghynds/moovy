package com.github.greghynds.moovy.arch.presentation

sealed class ScreenState {
    object Display : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: Throwable) : ScreenState()
}