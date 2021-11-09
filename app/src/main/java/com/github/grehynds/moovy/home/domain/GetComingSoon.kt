package com.github.grehynds.moovy.home.domain

import com.github.grehynds.moovy.arch.domain.Params
import com.github.grehynds.moovy.arch.domain.UseCase
import com.github.grehynds.moovy.home.MoviesList

class GetComingSoon(private val repo: MoviesRepo) : UseCase<Params, MoviesList>() {

    override suspend fun operation(params: Params): Result<MoviesList> {
        return repo.fetch()
    }
}