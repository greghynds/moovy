package com.github.grehynds.moovy

import com.github.grehynds.moovy.home.presentation.HomeState

data class AppState(
    val home : HomeState
) {
    companion object {
        val INITIAL = AppState(
            home = HomeState.loading()
        )
    }
}