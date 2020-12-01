package com.semi.awlem.utility

import android.app.Activity
import com.andrognito.flashbar.Flashbar
import com.andrognito.flashbar.anim.FlashAnim
import com.semi.awlem.R

object SnackBar {


    fun Activity.customSnackBar(
        title: Int,
        message: Int,
        iconId: Int,
        onDismiss: () -> Unit
    ) {
        Flashbar.Builder(this)
            .gravity(Flashbar.Gravity.TOP)
            .duration(5000)
            .backgroundColorRes(R.color.primary)
            .titleColorRes(R.color.white)
            .messageColorRes(R.color.white)
            .icon(iconId)
            .title(getString(title))
            .message(getString(message))
            .showIcon()
            .enableSwipeToDismiss()
            .vibrateOn(Flashbar.Vibration.SHOW, Flashbar.Vibration.DISMISS)
            .iconAnimation(
                FlashAnim.with(this)
                    .animateIcon()
                    .pulse()
                    .duration(1000)
                    .accelerate()
            )
            .iconColorFilterRes(R.color.transparent)
            .enterAnimation(
                FlashAnim.with(this)
                    .animateBar()
                    .duration(750)
                    .alpha()
                    .overshoot()
            )
            .exitAnimation(
                FlashAnim.with(this)
                    .animateBar()
                    .duration(400)
                    .accelerateDecelerate()
            )
            .barShowListener(object : Flashbar.OnBarShowListener {
                override fun onShowing(bar: Flashbar) {
                }

                override fun onShowProgress(bar: Flashbar, progress: Float) {
                }

                override fun onShown(bar: Flashbar) {
                    onDismiss()
                }
            })
            .build().show()


    }

    fun Activity.customSnackBar(
        title: String,
        message: Int,
        iconId: Int,
        onDismiss: () -> Unit
    ) {
        Flashbar.Builder(this)
            .gravity(Flashbar.Gravity.TOP)
            .duration(5000)
            .backgroundColorRes(R.color.primary)
            .titleColorRes(R.color.white)
            .messageColorRes(R.color.white)
            .icon(iconId)
            .title(title)
            .message(getString(message))
            .showIcon()
            .enableSwipeToDismiss()
            .vibrateOn(Flashbar.Vibration.SHOW, Flashbar.Vibration.DISMISS)
            .iconAnimation(
                FlashAnim.with(this)
                    .animateIcon()
                    .pulse()
                    .duration(1000)
                    .accelerate()
            )
            .iconColorFilterRes(R.color.transparent)
            .enterAnimation(
                FlashAnim.with(this)
                    .animateBar()
                    .duration(750)
                    .alpha()
                    .overshoot()
            )
            .exitAnimation(
                FlashAnim.with(this)
                    .animateBar()
                    .duration(400)
                    .accelerateDecelerate()
            )
            .barShowListener(object : Flashbar.OnBarShowListener {
                override fun onShowing(bar: Flashbar) {
                }

                override fun onShowProgress(bar: Flashbar, progress: Float) {
                }

                override fun onShown(bar: Flashbar) {
                    onDismiss()
                }
            })
            .build().show()


    }
}

