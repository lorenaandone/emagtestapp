package com.example.emagtestapp.presentation.utils

import android.view.View
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(view: ImageView, url: String?) {
    url?.let {
        Glide.with(view).load(it).into(view)
    }
}

@BindingAdapter("isVisible")
fun isVisible(view: View, isVisible: Boolean) {
        view.isVisible = isVisible
}