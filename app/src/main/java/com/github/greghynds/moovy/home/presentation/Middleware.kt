package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.redux.Middleware
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.arch.async.Dispatchers
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.presentation.createThunk
import com.github.greghynds.moovy.home.domain.GetComingSoon

fun createGetComingSoonThunk(
    getComingSoon: GetComingSoon,
    dispatchers: Dispatchers
): Middleware<AppState> {
    return createThunk(LOAD_COMING_SOON, dispatchers) {
        getComingSoon.execute(Params.None)
            .fold(
                ::createLoadComingSoonSuccessAction,
                ::createLoadComingSoonFailureAction
            )
    }
}