package com.example.kmmsample.androidApp

import android.widget.ImageView
import androidx.databinding.BindingAdapter

class BindableAdapters() {
    companion object {
        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImage(view: ImageView, url: String?) {
            if (!url.isNullOrEmpty()) view.loadUserImage(url)
        }
    }
}
