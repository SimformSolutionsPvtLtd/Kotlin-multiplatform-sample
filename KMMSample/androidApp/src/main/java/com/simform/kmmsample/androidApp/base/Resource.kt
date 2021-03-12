package com.simform.kmmsample.androidApp.base

import com.simform.kmmsample.shared.datamodels.base.CustomException

/**
 * This class is used to pass api status
 */
class Resource<out T>(val status: Status, val responseData: T? = null, val throwable: CustomException? = null) {
    companion object {
        /**
         * This fun is used to return success data
         */
        fun <T> success(data: T?): Resource<T> {
            return Resource(Status.SUCCESS, data)
        }

        /**
         * This fun is used to return error data
         */
        fun <T> error(exception: CustomException): Resource<T> {
            return Resource(Status.ERROR, throwable = exception)
        }

        /**
         * This fun is used to return loading
         */
        fun <T> loading(): Resource<T> {
            return Resource(Status.LOADING)
        }
    }

    override fun toString(): String {
        return "Resource(status=$status, data=$responseData, throwable=$throwable)"
    }
}

/**
 * This is enum class returns the status of apis
 */
enum class Status {
    SUCCESS,
    ERROR,
    LOADING
}