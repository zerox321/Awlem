package com.semi.awlem.utility

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper

object ContextConverter {

    fun Context.getActivity(): Activity? {
        if (this is ContextWrapper) {
            return if (this is Activity) {
                this
            } else {
                this.baseContext.getActivity()
            }
        }
        return null
    }
}
