package com.github.grehynds.moovy.home.domain

import com.github.grehynds.moovy.home.MoviesList

interface MoviesRepo {
    suspend fun fetch(): Result<MoviesList>
}