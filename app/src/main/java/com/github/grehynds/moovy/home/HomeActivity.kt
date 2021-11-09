package com.github.grehynds.moovy.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.github.greghynds.redux.Store
import com.github.greghynds.redux.createStore
import com.github.grehynds.moovy.AppState
import com.github.grehynds.moovy.arch.async.AndroidDispatchers
import com.github.grehynds.moovy.arch.data.ClientConfig
import com.github.grehynds.moovy.arch.data.ObjectMapperProvider
import com.github.grehynds.moovy.arch.data.createApiClient
import com.github.grehynds.moovy.arch.presentation.createLoggingMiddleware
import com.github.grehynds.moovy.home.data.ComingSoonApi
import com.github.grehynds.moovy.home.domain.GetComingSoon
import com.github.grehynds.moovy.home.presentation.createGetComingSoonThunk
import com.github.grehynds.moovy.home.presentation.createLoadComingSoonAction
import com.github.grehynds.moovy.home.ui.HomeUi
import com.github.grehynds.moovy.rootReducer
import com.github.grehynds.moovy.ui.theme.MoovyTheme

class HomeActivity : ComponentActivity() {

    private val store: Store<AppState> by lazy {
        createStore(
            rootReducer,
            AppState.INITIAL,
            createLoggingMiddleware(),
            createGetComingSoonThunk(
                GetComingSoon(
                    ComingSoonApi(
                        createApiClient(ClientConfig(host = "https://imdb-api.com/en/API/", ObjectMapperProvider.get()))
                    )
                ),
                AndroidDispatchers
            )
        )
    }

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