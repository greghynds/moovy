package com.github.grehynds.moovy.home.presentation

import com.github.grehynds.moovy.arch.ScreenState
import com.github.grehynds.moovy.arch.ScreenState.*
import com.github.grehynds.moovy.home.MoviesList

data class HomeState(
    val screen: ScreenState,
    val comingSoon: MoviesList
) {
    companion object {
        fun loading() = HomeState(Loading, listOf())
        fun error(error: Throwable) = HomeState(Error(error), listOf())
        fun from(comingSoon: MoviesList) = HomeState(Display, comingSoon)
        fun empty() = HomeState(Display, listOf())
    }
}