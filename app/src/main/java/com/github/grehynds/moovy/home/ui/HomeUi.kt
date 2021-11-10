package com.github.grehynds.moovy.home.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rxjava2.subscribeAsState
import com.github.greghynds.redux.Store
import com.github.greghynds.redux.select
import com.github.grehynds.moovy.AppState
import com.github.grehynds.moovy.arch.presentation.ScreenState.*
import com.github.grehynds.moovy.home.presentation.HomeState
import com.github.grehynds.moovy.home.presentation.createLoadComingSoonAction

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