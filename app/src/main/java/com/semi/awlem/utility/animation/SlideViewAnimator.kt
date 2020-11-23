package com.semi.awlem.utility.animation

import android.animation.Animator
import android.view.View

object SlideViewAnimator {
    fun View.startSlideView(
        height:Float,
        onAnimationStart: () -> Unit,
        onAnimationEnd: () -> Unit
    ) {
        this.animate().translationY(height)
            .setListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {
                    onAnimationStart()

                }

                override fun onAnimationEnd(animation: Animator) {
                    onAnimationEnd()
                }

                override fun onAnimationCancel(animation: Animator) {}
                override fun onAnimationRepeat(animation: Animator) {}
            })

    }
}