package com.github.greghynds.moovy.arch.presentation

import android.util.Log
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.home.domain.GetComingSoon
import com.github.greghynds.moovy.home.presentation.createLoadComingSoonFailureAction
import com.github.greghynds.moovy.home.presentation.createLoadComingSoonSuccessAction
import com.github.greghynds.redux.Middleware
import com.github.greghynds.redux.Store
import com.github.grehynds.redux.fsa.Action
import com.github.grehynds.redux.fsa.isOfType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


interface Thunk<State> {
    fun createAction(store: Store<State>): Any
}


fun <State> createThunk(
    type: String,
    dispatchers: Dispatchers,
    block: suspend (Store<State>) -> Action
): Middleware<State> = { store ->
    { action ->
        action.apply {
            when {
                action.isOfType(type) -> CoroutineScope(dispatchers.main).launch {
                    store.dispatch(withContext(dispatchers.io) { block(store) })
                }
            }
        }
    }
}


fun createGetComingSoon(
    getComingSoon: GetComingSoon,
    dispatchers: Dispatchers
): Thunk<AppState> {
    return object : Thunk<AppState> {
        override fun createAction(store: Store<AppState>): Any {
            return CoroutineScope(dispatchers.main).launch {
                withContext(dispatchers.io) {
                    Log.d("Redux", "Fetching coming soon titles...")
                    store.dispatch(getComingSoon.execute(Params.None)
                        .onSuccess { x ->
                            Log.d("Redux", "Success! Fetched ${x.size} movies")
                        }
                        .fold(
                            ::createLoadComingSoonSuccessAction,
                            ::createLoadComingSoonFailureAction
                        )
                    )
                }
            }
        }
    }
}