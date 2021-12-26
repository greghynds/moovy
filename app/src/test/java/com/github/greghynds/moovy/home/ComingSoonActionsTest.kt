package com.github.greghynds.moovy.home

import com.github.greghynds.moovy.arch.data.ApiError
import com.github.greghynds.moovy.home.domain.model.Movie
import com.github.greghynds.moovy.home.presentation.createLoadComingSoonAction
import com.github.greghynds.moovy.home.presentation.createLoadComingSoonFailureAction
import com.github.greghynds.moovy.home.presentation.createLoadComingSoonSuccessAction
import com.github.grehynds.redux.fsa.Action
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ComingSoonActionsTest {

    @Test
    fun `creates an action for loading the feed`() {
        val expected = Action("LOAD_COMING_SOON")

        val result = createLoadComingSoonAction()

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates an action for successfully fetching feed`() {
        val movies = listOf(Movie("id", "title"))
        val expected = Action("LOAD_COMING_SOON_SUCCESS", movies)

        val result = createLoadComingSoonSuccessAction(movies)

        assertThat(result).isEqualTo(expected)
    }

    @Test
    fun `creates an action for failing to fetch feed`() {
        val error = ApiError(500, "Couldn't fetch titles")
        val expected = Action("LOAD_COMING_SOON_FAILURE", error)

        val result = createLoadComingSoonFailureAction(error)

        assertThat(result).isEqualTo(expected)
    }
}