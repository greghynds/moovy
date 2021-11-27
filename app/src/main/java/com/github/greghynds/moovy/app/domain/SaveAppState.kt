package com.github.greghynds.moovy.app.domain

import android.content.SharedPreferences
import android.util.Log
import com.github.greghynds.moovy.app.AppState
import com.github.greghynds.moovy.arch.domain.UseCase
import com.google.gson.Gson
import kotlin.Result.Companion.success

class SaveAppState(
    private val repo: SharedPreferences,
    private val gson: Gson
) : UseCase<AppState, Unit>() {

    override suspend fun operation(params: AppState): Result<Unit> {
        return success(Unit).apply {
            val json = writeToJson(params)
            Log.d("Redux", "Saving state: $json")
            repo.edit().putString(KEY_APP_STATE, json).commit()
        }
    }

    private fun writeToJson(input: Any): String {
        return gson.toJson(input)
    }

    companion object {
        private const val KEY_APP_STATE = "app_state"
    }
}