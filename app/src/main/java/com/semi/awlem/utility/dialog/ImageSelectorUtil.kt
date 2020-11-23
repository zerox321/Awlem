package com.semi.awlem.utility.dialog

import android.app.Activity
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.Window
import androidx.databinding.DataBindingUtil
import com.github.dhaval2404.imagepicker.ImagePicker
import com.github.dhaval2404.imagepicker.constant.ImageProvider
import com.semi.awlem.R
import com.semi.awlem.databinding.DialogImageSelectorBinding
import java.io.File

object ImageSelectorUtil {
    private val GALLERY = ImageProvider.GALLERY
    private val CAMERA = ImageProvider.CAMERA


    fun Activity.showImageSelectorDialog(
        onSuccess: (file: File?) -> Unit
    ) {
        val dialog = Dialog(this, R.style.PauseDialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        val binding: DialogImageSelectorBinding = DataBindingUtil.inflate(
            LayoutInflater.from(this),
            R.layout.dialog_image_selector,
            null,
            false
        )

        binding.cameraIcon.setOnClickListener {
            this.pickImage(
                provider = CAMERA,
                onSuccess = { file: File? ->
                    onSuccess(file)
                })
            dialog.dismiss()

        }
        binding.galleryIcon.setOnClickListener {
            this.pickImage(
                provider = GALLERY,
                onSuccess = { file: File? ->
                    onSuccess(file)
                })
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

    private fun Activity.pickImage(provider: ImageProvider, onSuccess: (file: File?) -> Unit) {
        getImagePicker(
            activity = this,
            provider = provider,
            onSuccess = { file: File? -> onSuccess(file) },
            onError = { error: String ->

//                customSnackBar(
//                    activity,
//                    error,
//                    "",
//                    R.drawable.ic_image_error,
//                    R.color.colorPrimary
//                ) {}

            })

    }

    private fun getImagePicker(
        activity: Activity,
        provider: ImageProvider,
        onSuccess: (file: File?) -> Unit, onError: (errorMessage: String) -> Unit
    ) {
        ImagePicker.with(activity)
            .provider(provider)
            .compress(1024)
            .start { resultCode, data ->
                if (resultCode == Activity.RESULT_OK) {
                    onSuccess(ImagePicker.getFile(data))
                } else if (resultCode == ImagePicker.RESULT_ERROR) {
                    onError(ImagePicker.getError(data))

                }
            }
    }
}