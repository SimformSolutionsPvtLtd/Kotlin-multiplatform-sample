package com.example.kmmsample.shared.remote

import com.example.kmmsample.shared.datamodels.base.CustomException
import com.example.kmmsample.shared.datamodels.base.ErrorResponse
import com.example.kmmsample.shared.utils.CLIENT_REQUEST_EXCEPTION_RANGE
import com.example.kmmsample.shared.utils.REDIRECT_RESPONSE_EXCEPTION_RANGE
import com.example.kmmsample.shared.utils.RESPONSE_EXCEPTION_CODE
import com.example.kmmsample.shared.utils.SERVER_RESPONSE_EXCEPTION_RANGE
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

class BaseApiClass {

    //Create Http Client
    val httpClient by lazy {
        HttpClient {
            defaultRequest {
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
}