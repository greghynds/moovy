package com.github.grehynds.moovy.home.data

import com.fasterxml.jackson.annotation.JsonProperty

data class ComingSoonResponse(
    @JsonProperty("items") val movies: List<MovieDto>
)