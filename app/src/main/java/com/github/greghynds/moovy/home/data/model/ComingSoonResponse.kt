package com.github.greghynds.moovy.home.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ComingSoonResponse(
    @JsonProperty("items") val movies: List<MovieDto>
)