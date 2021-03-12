package com.simform.kmmsample.shared.datamodels.responsemodels

import kotlinx.serialization.Serializable

@Serializable
data class PopularMoviesResponse (
    val page: Int,
    val results: ArrayList<MovieEntity>,
    val total_pages: Int,
    val total_results: Int
)
