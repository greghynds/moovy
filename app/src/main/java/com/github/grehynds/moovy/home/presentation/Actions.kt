package com.github.grehynds.moovy.home.presentation

import com.github.greghynds.redux.Action
import com.github.grehynds.moovy.home.domain.ComingSoon


const val LOAD_COMING_SOON = "LOAD_COMING_SOON"
const val LOAD_COMING_SOON_SUCCESS = "LOAD_COMING_SOON_SUCCESS"
const val LOAD_COMING_SOON_FAILURE = "LOAD_COMING_SOON_FAILURE"

fun createLoadComingSoonAction() = Action(LOAD_COMING_SOON)
fun createLoadComingSoonSuccessAction(comingSoon: ComingSoon) = Action(LOAD_COMING_SOON_SUCCESS, comingSoon)
fun createLoadComingSoonFailureAction(error: Throwable) = Action(LOAD_COMING_SOON_FAILURE, error)
