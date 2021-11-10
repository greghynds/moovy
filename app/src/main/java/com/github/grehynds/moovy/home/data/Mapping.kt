package com.github.grehynds.moovy.home.data

import com.github.grehynds.moovy.home.data.model.MovieDto
import com.github.grehynds.moovy.home.domain.model.Movie

fun MovieDto.toEntity(): Movie {
    return Movie(id, title)
}