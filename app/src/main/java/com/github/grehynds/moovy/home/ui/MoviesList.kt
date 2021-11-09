package com.github.grehynds.moovy.home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.github.grehynds.moovy.home.domain.Movie

@Composable
fun MoviesList(
    movies: List<Movie>,
    onClick: (Movie) -> Unit = {}
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        movies.forEach { headline ->
            item {
                MovieCard(headline, onClick)
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
        }
    }
}