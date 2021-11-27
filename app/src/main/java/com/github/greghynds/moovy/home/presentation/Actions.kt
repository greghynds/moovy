package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.home.MoviesList
import com.github.greghynds.redux.Action


const val LOAD_COMING_SOON = "LOAD_COMING_SOON"
const val LOAD_COMING_SOON_SUCCESS = "LOAD_COMING_SOON_SUCCESS"
const val LOAD_COMING_SOON_FAILURE = "LOAD_COMING_SOON_FAILURE"

const val RESTORE_APP_STATE = "RESTORE_APP_STATE"
const val RESTORE_APP_STATE_SUCCESS = "RESTORE_APP_STATE_SUCCESS"
const val RESTORE_APP_STATE_FAILURE = "RESTORE_APP_STATE_FAILURE"

fun createRestoreAppStateAction() = Action(RESTORE_APP_STATE)
fun createRestoreAppStateSuccessAction(state: AppState) = Action(RESTORE_APP_STATE_SUCCESS, state)
fun createRestoreAppStateFailureAction(error: Throwable) = Action(RESTORE_APP_STATE_FAILURE, error)

fun createLoadComingSoonAction() = Action(LOAD_COMING_SOON)
fun createLoadComingSoonSuccessAction(movies: MoviesList) = Action(LOAD_COMING_SOON_SUCCESS, movies)
fun createLoadComingSoonFailureAction(error: Throwable) = Action(LOAD_COMING_SOON_FAILURE, error)