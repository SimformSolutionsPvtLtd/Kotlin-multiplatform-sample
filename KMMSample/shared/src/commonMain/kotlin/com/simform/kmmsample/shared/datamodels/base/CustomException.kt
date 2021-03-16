package com.simform.kmmsample.shared.datamodels.base

import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.readUTF8Line
import kotlinx.serialization.json.Json

// This will fetch error data from the api
class CustomException(var errorResponse: ErrorResponse?) : Exception() {

    companion object {
        suspend fun getError(responseContent: ByteReadChannel): ErrorResponse? {
            try {
                responseContent.readUTF8Line()?.let {
                    return Json.decodeFromString(ErrorResponse.serializer(), it)
                }
            } catch (e: Exception) {
                throw IllegalArgumentException("not a parsable error")
            }
            return null
        }
    }
}