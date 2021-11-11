package com.github.greghynds.moovy.arch.data

import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import retrofit2.Response

class ResponseMappingTest {

    @Test
    fun `returns result when response is successful`() {
        val data = "xxx"
        val response = Response.success(data)

        val result = response.toResult()

        assertThat(result).isEqualTo(Result.success(data))
    }

    @Test
    fun `returns error when response is not successful`() {
        val code = 500
        val message = "Error"
        val body = ResponseBody.create("application/json; charset=UTF-8".toMediaTypeOrNull(), message)
        val response = Response.error<String>(code, body)

        val result = response.toResult()

        assertThat(result.exceptionOrNull())
            .isInstanceOf(ApiError::class.java)
            .hasMessage(message)
    }
}