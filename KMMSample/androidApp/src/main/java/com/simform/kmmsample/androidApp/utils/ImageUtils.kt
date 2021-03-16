package com.simform.kmmsample.androidApp.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

fun ImageView.loadUserImage(url: Any?) {
    url?.let { image ->
        val options = RequestOptions().skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        val requestBuilder = Glide.with(context).load(image).apply(options)
        requestBuilder.into(this)
    }
}