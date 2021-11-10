package com.github.greghynds.moovy.arch.presentation

import com.github.greghynds.redux.Action
import com.github.greghynds.redux.Middleware
import com.github.greghynds.redux.Store
import com.github.greghynds.moovy.arch.async.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

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