package com.github.greghynds.moovy.app.presentation

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.domain.LoadAppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.presentation.Thunk
import com.github.greghynds.moovy.home.presentation.createRestoreAppStateFailureAction
import com.github.greghynds.moovy.home.presentation.createRestoreAppStateSuccessAction
import com.github.greghynds.redux.Store
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun createRestoreAppStateAction(
    loadAppState: LoadAppState,
    dispatchers: Dispatchers
): Thunk<AppState> {
    return object : Thunk<AppState> {
        override fun create(store: Store<AppState>): Any {
            return CoroutineScope(dispatchers.main).launch {
                withContext(dispatchers.io) {
                    store.dispatch(
                        loadAppState.execute(Params.None)
                            .fold(
                                ::createRestoreAppStateSuccessAction,
                                ::createRestoreAppStateFailureAction
                            )
                    )
                }
            }
        }
    }
}