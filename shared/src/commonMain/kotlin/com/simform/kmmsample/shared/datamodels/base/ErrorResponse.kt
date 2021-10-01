package com.simform.kmmsample.shared.datamodels.base

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Custom Error class according to error thrown by api
@Serializable
data class ErrorResponse (
    var statusCode: Int? = 0,
    @SerialName("status_message")
    var statusMessage: String? = "",
    var success: Boolean? = false
)