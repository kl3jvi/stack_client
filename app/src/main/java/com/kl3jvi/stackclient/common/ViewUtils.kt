package com.kl3jvi.stackclient.common

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment

object ViewUtils {
    fun View.show() {
        visibility = View.VISIBLE
    }

    fun View.hide() {
        visibility = View.GONE
    }

    fun Fragment.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(requireContext(), message, duration).show()
    }

}