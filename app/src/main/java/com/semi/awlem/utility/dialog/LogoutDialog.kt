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
import com.semi.awlem.databinding.DialogLogoutGuestBinding

object LogoutDialog {

    fun Context.showLogoutDialog(
        onLogoutClick: () -> Unit

    ) {
        val dialog = Dialog(this, R.style.PauseDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding: DialogLogoutGuestBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.dialog_logout_guest,
            null,
            false
        )
        binding.logoutBt.setOnClickListener {
            onLogoutClick()
            dialog.dismiss()
        }


        dialog.setContentView(binding.root)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val width = (this.resources.displayMetrics.widthPixels * 0.9).toInt()
        dialog.window?.setLayout(
            width,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        dialog.show()
    }
}