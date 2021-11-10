package com.github.greghynds.moovy.home.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieDto(
    @JsonProperty("id") val id: String,
    @JsonProperty("title") val title: String
)