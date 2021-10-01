package com.simform.kmmsample.shared

import com.simform.kmmsample.shared.datamodels.base.CustomException
import com.simform.kmmsample.shared.datamodels.base.ErrorResponse
import com.simform.kmmsample.shared.utils.ApiEndPoints
import com.simform.kmmsample.shared.utils.CLIENT_REQUEST_EXCEPTION_RANGE
import com.simform.kmmsample.shared.utils.REDIRECT_RESPONSE_EXCEPTION_RANGE
import com.simform.kmmsample.shared.utils.RESPONSE_EXCEPTION_CODE
import com.simform.kmmsample.shared.utils.SERVER_RESPONSE_EXCEPTION_RANGE
import io.ktor.client.HttpClient
import io.ktor.client.call.receive
import io.ktor.client.engine.ios.Ios
import io.ktor.client.engine.ios.IosHttpRequestException
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.HttpResponseValidator
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ResponseException
import io.ktor.client.features.ServerResponseException
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.host
import io.ktor.http.ContentType
import io.ktor.http.contentType
import platform.Foundation.setHTTPShouldUsePipelining

actual class HttpBaseClient {
    actual val httpClient: HttpClient = HttpClient(Ios) {
        defaultRequest {
            host = ApiEndPoints.BASE.url
            contentType(ContentType.Application.Json)
        }

        engine {
            // this: IosClientEngineConfig
            configureRequest {
                setHTTPShouldUsePipelining(true)
            }
        }

        // Validate Response
        expectSuccess = false
        // JSON Deserializer
        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            }
            serializer = KotlinxSerializer(json)
        }

        HttpResponseValidator {
            validateResponse { response ->
                when (response.status.value) {
                    in REDIRECT_RESPONSE_EXCEPTION_RANGE -> throw RedirectResponseException(response, "")
                    in CLIENT_REQUEST_EXCEPTION_RANGE -> throw ClientRequestException(response, "")
                    in SERVER_RESPONSE_EXCEPTION_RANGE -> throw ServerResponseException(response, "")
                }
                if (response.status.value >= RESPONSE_EXCEPTION_CODE) {
                    throw ResponseException(response, "")
                }
            }
            handleResponseException { cause ->
                var error = ErrorResponse()
                when (cause) {
                    is ResponseException -> {
                        error = cause.response.receive()
                        error.statusCode = cause.response.status.value
                    }
                    is IosHttpRequestException -> {
                        CustomException.getNoInternetError()
                    }
                    else -> CustomException.getDefaultError(cause.message)
                }
                throw CustomException(error)
            }
        }
    }
}