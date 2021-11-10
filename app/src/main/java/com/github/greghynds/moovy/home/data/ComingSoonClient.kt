package com.github.greghynds.moovy.home.data

import com.github.greghynds.moovy.home.data.model.ComingSoonResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface ComingSoonClient {

    @GET(COMING_SOON_ENDPOINT)
    fun fetch(): Deferred<Response<ComingSoonResponse>>
}