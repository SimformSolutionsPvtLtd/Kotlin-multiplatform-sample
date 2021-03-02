package com.example.kmmsample.androidApp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kmmsample.androidApp.base.Resource
import com.example.kmmsample.androidApp.utils.initWith
import com.example.kmmsample.shared.datamodels.responsemodels.PopularMoviesResponse
import com.example.kmmsample.shared.remote.BaseApiClass
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    var apiService = BaseApiClass()
    var popularMovieResponse = MutableLiveData<Resource<PopularMoviesResponse>>()
    var progressBarVisibility = MutableLiveData<Boolean>().initWith(true)

    fun callMovieList() {
        viewModelScope.launch {
            popularMovieResponse.postValue(Resource.loading())
            apiService.getMovies()?.fold(
                failed = {
                    popularMovieResponse.postValue(Resource.error(it))
                },
                succeeded = {
                    popularMovieResponse.postValue(Resource.success(it))
                }
            )
        }
    }

}