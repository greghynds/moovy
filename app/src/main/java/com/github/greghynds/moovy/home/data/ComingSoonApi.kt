package com.github.greghynds.moovy.home.data

import com.github.greghynds.moovy.arch.data.toResult
import com.github.greghynds.moovy.home.MoviesList
import com.github.greghynds.moovy.home.domain.MoviesRepo

class ComingSoonApi(private val client: ComingSoonClient) : MoviesRepo {

    override suspend fun fetch(): Result<MoviesList> {
        return client.fetch()
            .await()
            .toResult()
            .map { response -> response.movies.map { movie -> movie.toEntity() } }
    }
}