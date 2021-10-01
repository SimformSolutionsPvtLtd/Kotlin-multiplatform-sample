package com.simform.kmmsample.shared.remote

import com.simform.kmmsample.shared.HttpBaseClient
import com.simform.kmmsample.shared.datamodels.base.CustomException
import com.simform.kmmsample.shared.datamodels.base.Either
import com.simform.kmmsample.shared.datamodels.base.Failure
import com.simform.kmmsample.shared.datamodels.base.Success
import com.simform.kmmsample.shared.datamodels.responsemodels.PopularMoviesResponse
import com.simform.kmmsample.shared.utils.API_KEY
import com.simform.kmmsample.shared.utils.ApiEndPoints
import com.simform.kmmsample.shared.utils.HEADER_AUTHORIZATION
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class BaseApiClass {

    //Create Http Client
    private var httpClient = HttpBaseClient().httpClient

    @Throws(Exception::class)
    suspend fun getMovies() : Either<CustomException, PopularMoviesResponse>? {
        return try {
            val response = httpClient.get<PopularMoviesResponse>(ApiEndPoints.POPULAR_MOVIES.url) {
                parameter(HEADER_AUTHORIZATION, API_KEY)
            }
            Success(response)
        } catch (e: Exception) {
            Failure(e as CustomException)
        }
    }
}