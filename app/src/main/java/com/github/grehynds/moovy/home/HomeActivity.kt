package com.github.grehynds.moovy.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.github.greghynds.redux.Store
import com.github.greghynds.redux.createStore
import com.github.grehynds.moovy.AppState
import com.github.grehynds.moovy.arch.presentation.createLoggingMiddleware
import com.github.grehynds.moovy.home.presentation.createLoadComingSoonAction
import com.github.grehynds.moovy.home.ui.HomeUi
import com.github.grehynds.moovy.rootReducer
import com.github.grehynds.moovy.ui.theme.MoovyTheme

class HomeActivity : ComponentActivity() {

    private val store: Store<AppState> by lazy { createStore(rootReducer, AppState.INITIAL, createLoggingMiddleware()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoovyTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeUi(store)
                }
            }
        }

        store.dispatch(createLoadComingSoonAction())
    }
}