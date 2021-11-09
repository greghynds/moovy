package com.github.grehynds.moovy.home.domain

data class ComingSoon(val movies: List<Movie> = listOf())

data class Movie(val id: String)
