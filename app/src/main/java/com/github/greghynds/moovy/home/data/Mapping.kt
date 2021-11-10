package com.github.greghynds.moovy.home.data

import com.github.greghynds.moovy.home.data.model.MovieDto
import com.github.greghynds.moovy.home.domain.model.Movie

fun MovieDto.toEntity(): Movie {
    return Movie(id, title)
}