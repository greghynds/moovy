package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.presentation.Thunk
import com.github.greghynds.moovy.home.MoviesList
import com.github.greghynds.moovy.home.domain.GetComingSoon
import com.github.greghynds.redux.Store
import com.github.grehynds.redux.fsa.Action
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


const val LOAD_COMING_SOON = "LOAD_COMING_SOON"
const val LOAD_COMING_SOON_SUCCESS = "LOAD_COMING_SOON_SUCCESS"
const val LOAD_COMING_SOON_FAILURE = "LOAD_COMING_SOON_FAILURE"

const val RESTORE_APP_STATE_SUCCESS = "RESTORE_APP_STATE_SUCCESS"
const val RESTORE_APP_STATE_FAILURE = "RESTORE_APP_STATE_FAILURE"

fun createRestoreAppStateSuccessAction(state: AppState) = Action(RESTORE_APP_STATE_SUCCESS, state)
fun createRestoreAppStateFailureAction(error: Throwable) = Action(RESTORE_APP_STATE_FAILURE, error)

fun createLoadComingSoonAction() = Action(LOAD_COMING_SOON)
fun createLoadComingSoonSuccessAction(movies: MoviesList) = Action(LOAD_COMING_SOON_SUCCESS, movies)
fun createLoadComingSoonFailureAction(error: Throwable) = Action(LOAD_COMING_SOON_FAILURE, error)

fun createGetComingSoonAction(
    getComingSoon: GetComingSoon,
    dispatchers: Dispatchers
): Thunk<AppState> {
    return object : Thunk<AppState> {
        override fun create(store: Store<AppState>): Any {
            store.dispatch(createLoadComingSoonAction())

            return CoroutineScope(dispatchers.main).launch {
                withContext(dispatchers.io) {
                    store.dispatch(
                        getComingSoon.execute(Params.None)
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