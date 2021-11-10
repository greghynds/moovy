package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.redux.Reducer
import com.github.greghynds.moovy.home.MoviesList


val homeReducer: Reducer<HomeState> = { state, action ->
    when {
        action.isOfType(LOAD_COMING_SOON) -> HomeState.loading()
        action.isOfType(LOAD_COMING_SOON_SUCCESS) -> HomeState.from(action.payload as MoviesList)
        action.isOfType(LOAD_COMING_SOON_FAILURE) -> HomeState.error(action.payload as Throwable)
        else -> state
    }
}