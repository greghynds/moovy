package com.github.grehynds.moovy.home.presentation

import com.github.grehynds.moovy.home.domain.ComingSoon
import com.github.grehynds.moovy.arch.ScreenState
import com.github.grehynds.moovy.arch.ScreenState.*

data class HomeState(
    val screenState: ScreenState,
    val comingSoon: ComingSoon
) {
    companion object {
        fun loading() = HomeState(Loading, ComingSoon())
        fun error(error: Throwable) = HomeState(Error(error), ComingSoon())
        fun from(comingSoon: ComingSoon) = HomeState(Display, comingSoon)
    }
}