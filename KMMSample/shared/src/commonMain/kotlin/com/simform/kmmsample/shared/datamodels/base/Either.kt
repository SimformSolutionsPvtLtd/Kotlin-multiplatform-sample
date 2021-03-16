package com.simform.kmmsample.shared.datamodels.base

// This class will be used to handle failure and Success response from the api.
sealed class Either<out F, out S> {
    // Execute failure block if we receive any response from api else will execute success block in which we can get our data
    inline fun <T> fold(failed: (F) -> T, succeeded: (S) -> T): T =
        when (this) {
            is Failure -> failed(failure)
            is Success -> succeeded(success)
        }
}

data class Failure<out F>(val failure: F) : Either<F, Nothing>()

data class Success<out S>(val success: S) : Either<Nothing, S>()