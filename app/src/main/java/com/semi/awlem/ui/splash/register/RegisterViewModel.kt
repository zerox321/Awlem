package com.semi.awlem.ui.splash.register

import android.os.Bundle
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.isNotEqual
import com.semi.awlem.utility.showErrorSnackBar
import kotlinx.coroutines.launch

class RegisterViewModel @ViewModelInject constructor(private val repository: RegisterRepository) :
    BaseViewModel() {
    val fullName = MutableLiveData<String>("")
    val email = MutableLiveData<String>("")
    val phone = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")
    val confirmPassword = MutableLiveData<String>("")

    fun registerClick(
        v: View,
        nameTextInput: TextInputEditText,
        emailTextInput: TextInputEditText,
        phoneTextInput: TextInputEditText,
        passwordTextInput: TextInputEditText,
        confirmPasswordTextInput: TextInputEditText
    ) {
        val activity = v.context.getActivity()

        val fullNameValue = fullName.value ?: ""
        val emailValue = email.value ?: ""
        val phoneValue = phone.value ?: ""
        val passwordValue = password.value ?: ""
        val confirmPasswordValue = confirmPassword.value ?: ""
        when {
            isInputEmpty(fullNameValue) -> showErrorSnackBar(
                activity = activity,
                editText = nameTextInput,
                errorTitleId = R.string.fullNameReq,
                errorMessageId = R.string.re_regiter,
                errorIconId = R.drawable.ic_user_error
            )
            isInputEmpty(emailValue) -> showErrorSnackBar(
                activity = activity,
                editText = emailTextInput,
                errorTitleId = R.string.emailReq,
                errorMessageId = R.string.re_regiter,
                errorIconId = R.drawable.ic_email_req
            )
            isInputEmpty(phoneValue) -> showErrorSnackBar(
                activity = activity,
                editText = phoneTextInput,
                errorTitleId = R.string.phoneReq,
                errorMessageId = R.string.re_regiter,
                errorIconId = R.drawable.ic_phone_error
            )
            isInputEmpty(passwordValue) -> showErrorSnackBar(
                activity = activity,
                editText = passwordTextInput,
                errorTitleId = R.string.PasswordReq,
                errorMessageId = R.string.re_regiter,
                errorIconId = R.drawable.ic_password_error
            )
            isInputEmpty(confirmPasswordValue) -> showErrorSnackBar(
                activity = activity,
                editText = confirmPasswordTextInput,
                errorTitleId = R.string.confirmPasswordReq,
                errorMessageId = R.string.re_regiter,
                errorIconId = R.drawable.ic_password_error
            )
            isNotEqual(passwordValue, confirmPasswordValue) -> showErrorSnackBar(
                activity = activity,
                editText = passwordTextInput,
                errorTitleId = R.string.misMatchPassword,
                errorMessageId = R.string.re_regiter,
                errorIconId = R.drawable.ic_password_error
            )

            else -> {
                v.hideKeyboard()
                viewModelScope.launch {
                    repository.registerTaskRepo(name = fullNameValue,
                        email = emailValue,
                        phone = phoneValue,
                        password = passwordValue,
                        onLoading = { loading: Boolean -> _isLoading.value = loading },
                        onActivate = { token ->
                            v.findNavigationController().navigateTo(
                                id = R.id.action_RegisterFragment_to_VerificationFragment,
                                args = Bundle().apply { putString("token", token) }
                            )
                        },
                        onError = { messageTitle: String?, messageContent: Int, icon: Int ->
                            activity?.customSnackBar(
                                title = messageTitle ?: "",
                                message = messageContent,
                                iconId = icon,
                            ) {}
                        })

                }
            }

        }
    }
}