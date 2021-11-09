package com.github.grehynds.moovy.home.data

import com.github.grehynds.moovy.arch.data.toResult
import com.github.grehynds.moovy.home.MoviesList
import com.github.grehynds.moovy.home.domain.MoviesRepo

class ComingSoonApi(private val client: ComingSoonClient) : MoviesRepo {

    override suspend fun fetch(): Result<MoviesList> {
        return client.fetch()
            .await()
            .toResult()
            .map { response -> response.movies.map { movie -> movie.toEntity() } }
    }
}