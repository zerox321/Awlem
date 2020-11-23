package com.semi.awlem.ui.splash.login

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.showErrorSnackBar
import kotlinx.coroutines.launch


class LoginViewModel : BaseViewModel() {
    val phone = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")

    fun registerClick(
        v: View
    ) {
        v.findNavigationController().navigateTo(
            id = R.id.action_LoginFragment_to_RegisterFragment,
        )
    }

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