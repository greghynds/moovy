package com.github.greghynds.moovy.app.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.github.greghynds.moovy.app.ui.common.Error
import com.github.greghynds.moovy.app.ui.theme.MoovyTheme


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MoovyTheme {
        Error()
    }
}