package com.kl3jvi.stackclient.bindings

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.kl3jvi.stackclient.R
import com.kl3jvi.stackclient.common.GlideApp

object ViewBinding {
    @JvmStatic
    @BindingAdapter("image")
    fun setImage(image: ImageView, url: String?) {
        if (!url.isNullOrEmpty()) {
            GlideApp.with(image.context).load(url).centerCrop()
                .placeholder(R.drawable.ic_no_image)
                .into(image)
        }
    }
}