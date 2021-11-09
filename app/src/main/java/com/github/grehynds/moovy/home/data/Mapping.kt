package com.github.grehynds.moovy.home.data

import com.github.grehynds.moovy.home.domain.Movie

fun MovieDto.toEntity(): Movie {
    return Movie(id, title)
}