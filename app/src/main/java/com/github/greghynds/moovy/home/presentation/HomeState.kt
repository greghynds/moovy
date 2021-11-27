package com.github.greghynds.moovy.home.presentation

import com.github.greghynds.moovy.arch.presentation.Display
import com.github.greghynds.moovy.arch.presentation.Error
import com.github.greghynds.moovy.arch.presentation.Loading
import com.github.greghynds.moovy.arch.presentation.ScreenState
import com.github.greghynds.moovy.home.MoviesList

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