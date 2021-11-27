package com.github.greghynds.moovy.app.domain

import android.content.SharedPreferences
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.domain.UseCase
import com.google.gson.Gson
import kotlin.Result.Companion.success

class LoadAppState(
    private val repo: SharedPreferences,
    private val gson: Gson
) : UseCase<Params, AppState>() {

    override suspend fun operation(params: Params): Result<AppState> {
        return success(readJson(KEY_APP_STATE, default = AppState.INITIAL))
    }

    private inline fun <reified T : Any> readJson(key: String, default: T): T {
        return gson.fromJson(repo.getString(key, writeToJson(default)), T::class.java)
    }

    private fun writeToJson(input: Any): String {
        return gson.toJson(input)
    }

    companion object {
        private const val KEY_APP_STATE = "app_state"
    }
}