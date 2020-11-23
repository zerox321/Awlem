package com.semi.awlem.utility

import android.app.Activity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.semi.awlem.R
import com.semi.awlem.utility.SnackBar.customSnackBar


fun showErrorEditText(editText: View, errorId: Int) {
    editText.requestFocus()
    shake(editText)
}

fun showErrorSnackBar(
    activity: Activity?,
    editText: View,
    errorTitleId: Int,
    errorMessageId: Int,
    errorIconId: Int
) {
    showErrorEditText(editText = editText, errorId = errorTitleId)
    activity?.customSnackBar(
        errorTitleId,
        errorMessageId,
        errorIconId,
    ) {}
}

fun shakeErrorSnackBar(
    activity: Activity?,
    v: View,
    errorTitleId: Int,
    errorMessageId: Int,
    errorIconId: Int
) {
    shake(v)
    activity?.customSnackBar(
        errorTitleId,
        errorMessageId,
        errorIconId
    ) {}
}


fun shake(v: View) {
    val shake: Animation = AnimationUtils.loadAnimation(v.context, R.anim.shake)
    v.startAnimation(shake)
}

fun isInputEmpty(input: String?): Boolean {
    return input == null || input.trim().isEmpty()
}

fun isNotEqual(password: String, confirmPassword: String): Boolean {
    return password != confirmPassword
}

fun isEmailValid(email: String): Boolean {
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}

fun isPhoneValid(phone: String, length: Int, startKey: String): Boolean {
    return android.util.Patterns.PHONE.matcher(phone)
        .matches() && phone.length == length && phone.startsWith(startKey)
}