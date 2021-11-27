package com.github.greghynds.moovy.home

import com.github.greghynds.moovy.home.presentation.createRestoreAppStateAction
import com.github.greghynds.redux.Action
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class AppStateActionsTest {

    @Test
    fun `creates an action to restore the app state`() {
        val expected = Action("RESTORE_APP_STATE")

        val result = createRestoreAppStateAction()

        assertThat(result).isEqualTo(expected)
    }
}