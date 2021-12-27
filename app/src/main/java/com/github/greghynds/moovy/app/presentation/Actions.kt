package com.github.greghynds.moovy.app.presentation

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.domain.LoadAppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.home.presentation.createRestoreAppStateFailureAction
import com.github.greghynds.moovy.home.presentation.createRestoreAppStateSuccessAction
import com.github.greghynds.thunk.Thunk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


fun createRestoreAppStateAction(
    loadAppState: LoadAppState,
    dispatchers: Dispatchers
) = Thunk<AppState> { store ->
    CoroutineScope(dispatchers.main).launch {
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