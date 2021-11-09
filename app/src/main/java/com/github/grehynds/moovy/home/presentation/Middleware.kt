package com.github.grehynds.moovy.home.presentation

import com.github.greghynds.redux.Middleware
import com.github.grehynds.moovy.AppState
import com.github.grehynds.moovy.arch.async.Dispatchers
import com.github.grehynds.moovy.arch.domain.Params
import com.github.grehynds.moovy.arch.presentation.createThunk
import com.github.grehynds.moovy.home.domain.GetComingSoon

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