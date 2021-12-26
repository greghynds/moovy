package com.github.greghynds.moovy.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.app.presentation.createRestoreAppStateAction
import com.github.greghynds.moovy.app.ui.theme.MoovyTheme
import com.github.greghynds.moovy.home.presentation.createGetComingSoonAction
import com.github.greghynds.moovy.home.ui.HomeUi
import com.github.greghynds.redux.Store
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject

class HomeActivity : ComponentActivity() {

    private val store: Store<AppState> by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoovyTheme {
                Surface(color = MaterialTheme.colors.background) {
                    HomeUi(store)
                }
            }
        }

        store.dispatch(createGetComingSoonAction(get(), get()))
    }

    override fun onResume() {
        super.onResume()
        store.dispatch(createRestoreAppStateAction(get(), get()))
    }
}