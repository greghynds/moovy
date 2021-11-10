package com.github.greghynds.moovy.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava2.subscribeAsState
import com.github.greghynds.redux.Store
import com.github.greghynds.redux.select
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.arch.presentation.ScreenState.*
import com.github.greghynds.moovy.home.presentation.HomeState
import com.github.greghynds.moovy.home.presentation.createLoadComingSoonAction
import com.github.greghynds.moovy.app.ui.common.Error
import com.github.greghynds.moovy.app.ui.common.Loading

@Composable
fun HomeUi(store: Store<AppState>) {

    val state: HomeState by store
        .select(AppState::home)
        .subscribeAsState(initial = HomeState.empty())

    when (state.screen) {
        is Loading -> Loading()
        is Error -> Error { store.dispatch(createLoadComingSoonAction()) }
        is Display -> MoviesList(state.comingSoon) { }
    }
}