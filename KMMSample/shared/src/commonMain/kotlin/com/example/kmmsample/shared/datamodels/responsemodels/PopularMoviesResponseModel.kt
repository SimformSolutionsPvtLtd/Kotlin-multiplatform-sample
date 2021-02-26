package com.example.kmmsample.shared.datamodels.responsemodels

import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesResponse (
    val page: Int,
    val results: List<MovieEntity>,
    val total_pages: Int,
    val total_results: Int
)
