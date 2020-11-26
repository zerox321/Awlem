package com.semi.awlem.utility.dialog

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.semi.awlem.R
import com.semi.awlem.databinding.DialogLoginGuestBinding

object LoginGuestDialog {

    fun Context.showLoginGuestDialog(
        isCancelable: Boolean? = false,
        onLoginClick: () -> Unit

    ) {
        val dialog = Dialog(this, R.style.PauseDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding: DialogLoginGuestBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.dialog_login_guest,
            null,
            false
        )
        binding.loginBt.setOnClickListener {
            onLoginClick()
        }


        dialog.setContentView(binding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val width = (this.resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog.setCanceledOnTouchOutside(isCancelable ?: false)
        dialog.setCancelable(isCancelable ?: false)
        dialog.window?.setLayout(
            width,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }
}