package com.simform.kmmsample.androidApp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.simform.kmmsample.androidApp.R
import com.simform.kmmsample.androidApp.databinding.MovieListBinding
import com.simform.kmmsample.shared.datamodels.responsemodels.MovieEntity

class MovieListAdapter : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var moviesList = arrayListOf<MovieEntity>()

    fun setList(movies: ArrayList<MovieEntity>) {
        moviesList = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val mBinding: MovieListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_list, parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(moviesList[position])
    }

    override fun getItemCount(): Int = moviesList.size

    inner class ViewHolder(private val binding: MovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movieEntity: MovieEntity) {
            binding.movieEntity = movieEntity
        }
    }
}