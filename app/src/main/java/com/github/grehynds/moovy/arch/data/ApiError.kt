package com.github.grehynds.moovy.arch.data

data class ApiError(
    val code: Int,
    override val message: String?
) : Throwable(message)