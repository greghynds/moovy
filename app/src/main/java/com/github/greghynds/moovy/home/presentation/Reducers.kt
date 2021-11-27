package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.moovy.home.MoviesList
import com.github.greghynds.redux.Reducer

@Suppress("UNCHECKED_CAST")
val homeReducer: Reducer<HomeState> = { state, action ->
    when (action.type) {
        LOAD_COMING_SOON -> HomeState.loading()
        LOAD_COMING_SOON_SUCCESS -> HomeState.from(action.payload as MoviesList)
        LOAD_COMING_SOON_FAILURE -> HomeState.error(action.payload as Throwable)
        else -> state
    }
}