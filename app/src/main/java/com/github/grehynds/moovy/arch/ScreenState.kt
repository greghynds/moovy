package com.github.grehynds.moovy.arch

sealed class ScreenState {
    object Display : ScreenState()
    object Loading : ScreenState()
    data class Error(val error: Throwable) : ScreenState()
}