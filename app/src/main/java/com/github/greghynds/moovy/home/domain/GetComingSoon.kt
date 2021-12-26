package com.github.greghynds.moovy.home.domain

import android.util.Log
import com.github.greghynds.moovy.arch.domain.Params
import com.github.greghynds.moovy.arch.domain.UseCase
import com.github.greghynds.moovy.home.MoviesList

class GetComingSoon(private val repo: MoviesRepo) : UseCase<Params, MoviesList>() {

    override suspend fun operation(params: Params): Result<MoviesList> {
        Log.d("Redux", "Hitting repository...")
        return repo.fetch()
    }
}