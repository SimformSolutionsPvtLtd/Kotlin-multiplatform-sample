package com.simform.kmmsample.shared

import io.ktor.client.HttpClient

expect class HttpBaseClient() {
    val httpClient: HttpClient
}
