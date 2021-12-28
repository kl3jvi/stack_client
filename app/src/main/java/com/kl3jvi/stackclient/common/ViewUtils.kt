package com.kl3jvi.stackclient.common

import android.view.View

object ViewUtils {
    fun View.show() {
        visibility = View.VISIBLE
    }

    fun View.hide() {
        visibility = View.GONE
    }
}