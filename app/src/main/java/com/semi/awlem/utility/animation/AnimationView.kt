package com.semi.awlem.utility.animation

import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

object AnimationView {
    fun View.setAnimationView(animID: Int, onAnimationEnd: () -> Unit) {
        val context = this.context
        val anim = AnimationUtils.loadAnimation(context, animID)
        this.startAnimation(anim)
        anim.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                onAnimationEnd()
            }

            override fun onAnimationStart(animation: Animation?) {}
        })
    }
}