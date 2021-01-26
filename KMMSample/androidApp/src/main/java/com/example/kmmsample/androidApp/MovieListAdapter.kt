package com.example.kmmsample.androidApp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kmmsample.androidApp.databinding.MovieListBinding
import com.example.kmmsample.shared.datamodels.responsemodels.MovieEntity

class MovieListAdapter() : RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    private var moviesList = arrayListOf<MovieEntity>()

    fun setList(movies: ArrayList<MovieEntity>) {
        moviesList = movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListAdapter.ViewHolder {
        val mBinding: MovieListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_list, parent, false)
        return ViewHolder(mBinding)
    }

    override fun onBindViewHolder(holder: MovieListAdapter.ViewHolder, position: Int) {
        holder.bind(moviesList[position], position)
    }

    override fun getItemCount(): Int = moviesList.size

    inner class ViewHolder(private val binding: MovieListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(userModelItem: MovieEntity, position: Int) {
            binding.movieEntity = userModelItem
        }
    }
}