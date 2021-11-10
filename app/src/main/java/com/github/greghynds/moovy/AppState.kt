package com.github.greghynds.moovy

import com.github.greghynds.moovy.home.presentation.HomeState

data class AppState(
    val home : HomeState
) {
    companion object {
        val INITIAL = AppState(
            home = HomeState.loading()
        )
    }
}