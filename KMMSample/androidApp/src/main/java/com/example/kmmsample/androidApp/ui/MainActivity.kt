package com.example.kmmsample.androidApp.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.kmmsample.androidApp.BR
import com.example.kmmsample.androidApp.R
import com.example.kmmsample.androidApp.base.Status
import com.example.kmmsample.androidApp.databinding.ActivityMainBinding
import com.example.kmmsample.shared.datamodels.responsemodels.PopularMoviesResponse

class MainActivity : AppCompatActivity() {

    private var viewModel = MainViewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // SetUp View Binding
        setUpBinding()
        // Call Movies Api
        callApi()

        // Handle Api Response
        viewModel.popularMovieResponse.observe(this, { response ->
            when (response.status) {
                Status.LOADING -> {
                    viewModel.progressBarVisibility.value = true
                }
                Status.SUCCESS -> {
                    viewModel.progressBarVisibility.postValue(false)
                    response.responseData?.let { movies -> setUpRecyclerView(movies) }
                }
                Status.ERROR -> {
                    viewModel.progressBarVisibility.postValue(false)
                    Toast.makeText(this, response.throwable?.errorResponse?.status_message, Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    // SetUp Movie List Adapter
    private fun setUpRecyclerView(popularMoviesResponse: PopularMoviesResponse) {
        val adapter = MovieListAdapter()
        adapter.setList(popularMoviesResponse.results)
        binding.recyclerViewMovies.adapter = adapter
    }

    private fun setUpBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            viewModel = this@MainActivity.viewModel
        }
    }

    // Call Get Movies Api
    private fun callApi() {
        viewModel.callMovieList()
    }
}
