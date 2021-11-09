package com.github.grehynds.moovy.home.presentation

import com.github.greghynds.redux.Reducer
import com.github.grehynds.moovy.home.domain.ComingSoon


val homeReducer: Reducer<HomeState> = { state, action ->
    when {
        action.isOfType(LOAD_COMING_SOON) -> HomeState.loading()
        action.isOfType(LOAD_COMING_SOON_SUCCESS) -> HomeState.from(action.payload as ComingSoon)
        action.isOfType(LOAD_COMING_SOON_FAILURE) -> HomeState.error(action.payload as Throwable)
        else -> state
    }
}