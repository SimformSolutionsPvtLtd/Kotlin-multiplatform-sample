package com.simform.kmmsample.shared.datamodels.base

import kotlinx.serialization.Serializable

// Custom Error class according to error thrown by api
@Serializable
data class ErrorResponse (
    val status_code: Int,
    val status_message: String,
    val success: Boolean?
)