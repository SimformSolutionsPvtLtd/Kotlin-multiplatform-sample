package com.simform.kmmsample.shared.remote

import com.simform.kmmsample.shared.datamodels.base.CustomException
import com.simform.kmmsample.shared.datamodels.base.Either
import com.simform.kmmsample.shared.datamodels.base.ErrorResponse
import com.simform.kmmsample.shared.utils.CLIENT_REQUEST_EXCEPTION_RANGE
import com.simform.kmmsample.shared.utils.REDIRECT_RESPONSE_EXCEPTION_RANGE
import com.simform.kmmsample.shared.utils.RESPONSE_EXCEPTION_CODE
import com.simform.kmmsample.shared.utils.SERVER_RESPONSE_EXCEPTION_RANGE
import com.simform.kmmsample.shared.datamodels.base.Failure
import com.simform.kmmsample.shared.datamodels.base.Success
import io.ktor.client.HttpClient
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.HttpResponseValidator
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import com.simform.kmmsample.shared.datamodels.responsemodels.PopularMoviesResponse
import com.simform.kmmsample.shared.utils.API_KEY
import com.simform.kmmsample.shared.utils.ApiEndPoints
import com.simform.kmmsample.shared.utils.HEADER_AUTHORIZATION
import io.ktor.client.request.get
import io.ktor.client.request.host
import io.ktor.client.request.parameter

class BaseApiClass {

    //Create Http Client
    private val httpClient by lazy {
        HttpClient {
            defaultRequest {
                host = ApiEndPoints.BASE.url
                contentType(ContentType.Application.Json)
            }
            install(Logging) {
                logger = Logger.DEFAULT
                level = LogLevel.ALL
            }
            expectSuccess = false
            HttpResponseValidator {
                validateResponse { response ->
                    when (response.status.value) {
                        in REDIRECT_RESPONSE_EXCEPTION_RANGE -> throw RedirectResponseException(response)
                        in CLIENT_REQUEST_EXCEPTION_RANGE -> throw ClientRequestException(response)
                        in SERVER_RESPONSE_EXCEPTION_RANGE -> throw ServerResponseException(response)
                    }
                    if (response.status.value >= RESPONSE_EXCEPTION_CODE) {
                        throw ResponseException(response)
                    }
                }
                handleResponseException { cause ->
                    val error = when (cause) {
                        is ClientRequestException -> {
                            CustomException.getError(cause.response.content)
                        }
                        else -> ErrorResponse(1, "UnKnown Error", false)
                    }
                    throw CustomException(error)
                }
            }
            // JSON Deserializer
            install(JsonFeature) {
                val json = Json { ignoreUnknownKeys = true }
                serializer = KotlinxSerializer(json)
            }
        }
    }

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