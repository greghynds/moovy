package com.github.greghynds.moovy.app.presentation

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.domain.LoadAppState
import com.github.greghynds.moovy.app.domain.SaveAppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.presentation.createThunk
import com.github.greghynds.moovy.home.presentation.*
import com.github.greghynds.redux.Middleware
import com.github.grehynds.redux.fsa.Action
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun createRestoreAppStateThunk(
    loadAppState: LoadAppState,
    dispatchers: Dispatchers
): Middleware<AppState> {
    return createThunk(RESTORE_APP_STATE, dispatchers) {
        loadAppState.execute(Params.None)
            .fold(
                ::createRestoreAppStateSuccessAction,
                ::createRestoreAppStateFailureAction
            )
    }
}

fun createSaveAppStateEffect(
    saveAppState: SaveAppState,
    dispatchers: Dispatchers
): Middleware<AppState> = { store ->
    { action ->
        if (action is Action) {

            val restoreActionTypes = listOf(RESTORE_APP_STATE, RESTORE_APP_STATE_SUCCESS, RESTORE_APP_STATE_FAILURE)
            val isRestoreActionType = !restoreActionTypes.contains((action as Action).type)

            action.also {
                if (isRestoreActionType) {
                    CoroutineScope(dispatchers.main).launch {
                        withContext(dispatchers.io) { saveAppState.execute(store.state) }
                    }
                }
            }
        }
    }
}