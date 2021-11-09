package com.github.grehynds.moovy.home.data

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ComingSoonClient {

    @GET(COMING_SOON_ENDPOINT)
    fun fetch(): Deferred<Response<ComingSoonResponse>>
}