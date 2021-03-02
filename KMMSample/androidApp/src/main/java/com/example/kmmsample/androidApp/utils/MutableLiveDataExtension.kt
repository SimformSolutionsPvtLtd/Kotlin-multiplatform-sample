package com.example.kmmsample.androidApp.utils

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.initWith(data: T): MutableLiveData<T> = this.apply {
    value = data
}