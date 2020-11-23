package com.semi.awlem.ui.splash.register

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.showErrorSnackBar
import kotlinx.coroutines.launch

    class RegisterViewModel : BaseViewModel() {
        val fullName = MutableLiveData<String>("")
        val email = MutableLiveData<String>("")
        val phone = MutableLiveData<String>("")
        val password = MutableLiveData<String>("")
        val confirmPassword = MutableLiveData<String>("")

        fun loginClick(
            v: View,
            phoneTextInput: TextInputEditText,
            passwordTextInput: TextInputEditText
        ) {
            val activity = v.context.getActivity()

            val phoneValue = phone.value
            val passwordValue = password.value
            when {
                isInputEmpty(phoneValue) -> showErrorSnackBar(
                    activity = activity,
                    editText = phoneTextInput,
                    errorTitleId = R.string.phoneReq,
                    errorMessageId = R.string.phoneReq,
                    errorIconId = R.drawable.ic_phone_error
                )
                isInputEmpty(passwordValue) -> showErrorSnackBar(
                    activity = activity,
                    editText = passwordTextInput,
                    errorTitleId = R.string.PasswordReq,
                    errorMessageId = R.string.PasswordReq,
                    errorIconId = R.drawable.ic_password_error
                )

                else -> {
                    v.hideKeyboard()
                    viewModelScope.launch {

                    }
                }

            }
        }
    }