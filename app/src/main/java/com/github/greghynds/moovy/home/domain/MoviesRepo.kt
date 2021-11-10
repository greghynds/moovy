package com.github.greghynds.moovy.home.domain

import com.github.greghynds.moovy.home.MoviesList

interface MoviesRepo {
    suspend fun fetch(): Result<MoviesList>
}