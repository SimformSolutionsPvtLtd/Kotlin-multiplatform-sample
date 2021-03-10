package com.example.kmmsample.androidApp.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
fun bindImage(view: ImageView, url: String?, placeHolder: Drawable?) {
    Glide.with(view.context)
        .load(url)
        .placeholder(placeHolder)
        .into(view)
}
