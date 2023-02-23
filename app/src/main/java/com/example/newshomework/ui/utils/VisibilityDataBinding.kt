package com.example.newshomework.ui.utils

import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

object VisibilityDataBinding {

    @JvmStatic
    @BindingAdapter("loading")
    fun ProgressBar.setVisibility(
        boolean: Boolean?
    ) {
        if (boolean != null) {
            this.isVisible = boolean
        }
    }

    @JvmStatic
    @BindingAdapter("empty")
    fun TextView.setVisibility(
        boolean: Boolean?
    ) {
        if (boolean != null) {
            this.isVisible = boolean
        }
    }
}