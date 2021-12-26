package com.github.greghynds.moovy.app

import com.github.greghynds.moovy.home.presentation.RESTORE_APP_STATE_SUCCESS
import com.github.greghynds.moovy.home.presentation.homeReducer
import com.github.greghynds.redux.Reducer
import com.github.grehynds.redux.fsa.isOfType

val rootReducer: Reducer<AppState> = { state, action ->
    when {
        action.isOfType(RESTORE_APP_STATE_SUCCESS) -> action.payload as AppState
        else -> AppState(
            home = homeReducer(state.home, action)
        )
    }
}