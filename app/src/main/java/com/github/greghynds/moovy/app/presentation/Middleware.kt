package com.github.greghynds.moovy.app.presentation

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.domain.SaveAppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.home.presentation.RESTORE_APP_STATE_FAILURE
import com.github.greghynds.moovy.home.presentation.RESTORE_APP_STATE_SUCCESS
import com.github.greghynds.redux.Middleware
import com.github.grehynds.redux.fsa.Action
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun createSaveAppStateMiddleware(
    saveAppState: SaveAppState,
    dispatchers: Dispatchers
): Middleware<AppState> = { store ->
    { action ->
        if (action.isRestoreStateAction()) {
            CoroutineScope(dispatchers.main).launch {
                withContext(dispatchers.io) { saveAppState.execute(store.state) }
            }
        }

        action
    }
}

private val restoreActionTypes =
    listOf(
        RESTORE_APP_STATE_SUCCESS,
        RESTORE_APP_STATE_FAILURE
    )

private fun Any.isRestoreStateAction(): Boolean {
    return this is Action && !restoreActionTypes.contains(type)
}