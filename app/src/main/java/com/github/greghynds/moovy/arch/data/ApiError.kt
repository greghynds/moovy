package com.github.greghynds.moovy.arch.data

data class ApiError(
    val code: Int,
    override val message: String?
) : Throwable(message)