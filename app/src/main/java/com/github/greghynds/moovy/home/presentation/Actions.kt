package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.redux.Action
import com.github.greghynds.moovy.home.MoviesList


const val LOAD_COMING_SOON = "LOAD_COMING_SOON"
const val LOAD_COMING_SOON_SUCCESS = "LOAD_COMING_SOON_SUCCESS"
const val LOAD_COMING_SOON_FAILURE = "LOAD_COMING_SOON_FAILURE"

fun createLoadComingSoonAction() = Action(LOAD_COMING_SOON)
fun createLoadComingSoonSuccessAction(movies: MoviesList) = Action(LOAD_COMING_SOON_SUCCESS, movies)
fun createLoadComingSoonFailureAction(error: Throwable) = Action(LOAD_COMING_SOON_FAILURE, error)
