package com.simform.kmmsample.androidApp.utils

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter(value = ["imageUrl", "placeHolder"], requireAll = false)
fun bindImage(view: ImageView, url: String?, placeHolder: Drawable?) {
    Glide.with(view.context)
        .load(url)
        .placeholder(placeHolder)
        .into(view)
}
