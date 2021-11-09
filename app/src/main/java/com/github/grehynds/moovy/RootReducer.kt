package com.github.grehynds.moovy

import com.github.greghynds.redux.Reducer
import com.github.grehynds.moovy.home.presentation.homeReducer

val rootReducer: Reducer<AppState> = { state, action ->
    AppState(
        home = homeReducer(state.home, action)
    )
}