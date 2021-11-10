package com.github.greghynds.moovy

import com.github.greghynds.redux.Reducer
import com.github.greghynds.moovy.home.presentation.homeReducer

val rootReducer: Reducer<AppState> = { state, action ->
    AppState(
        home = homeReducer(state.home, action)
    )
}