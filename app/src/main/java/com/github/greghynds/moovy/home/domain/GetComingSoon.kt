package com.github.greghynds.moovy.home.domain

import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.domain.UseCase
import com.github.greghynds.moovy.home.MoviesList

class GetComingSoon(private val repo: MoviesRepo) : UseCase<Params, MoviesList>() {

    override suspend fun operation(params: Params): Result<MoviesList> {
        return repo.fetch()
    }
}