package com.github.grehynds.moovy.home.data

import com.fasterxml.jackson.annotation.JsonProperty

data class MovieDto(
    @JsonProperty("id") val id: String,
    @JsonProperty("title") val title: String
)