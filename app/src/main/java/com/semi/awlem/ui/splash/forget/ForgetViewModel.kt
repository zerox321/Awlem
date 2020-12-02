package com.semi.awlem.ui.splash.forget

import android.view.View
import androidx.lifecycle.MutableLiveData
import com.google.android.material.textfield.TextInputEditText
import com.semi.awlem.base.BaseViewModel

class ForgetViewModel : BaseViewModel() {
    val emailAddress = MutableLiveData("")
    val mobile = MutableLiveData("")

    fun emailReset(v: View, _email: TextInputEditText) {
        val emailValue = emailAddress.value!!.trim()
//        when {
//            isInputEmpty(emailValue) -> showErrorEditText(_email, R.string.emailReq)
//            else -> {
//                hideSoftKeyboard(v)
//                viewModelScope.launch {
//                    repo.mailRestTaskRepo(
//                        emailValue,
//                        { isLoading.value = it },
//                        {
//                            navigate(
//                                v,
//                                R.id.action_ForgetPasswordFragment_to_ResetFragment,
//                                null,
//                                null,
//                                FragmentNavigatorExtras(_logo to "view")
//                            )
//                        },
//                        { messageId: Int, iconId: Int ->
//                            customSnackBar(
//                                v,
//                                v.context.getString(messageId),
//                                iconId
//                            ) {}
//                        })
//
//                }
//            }
    }


    fun phoneReset(v: View, _phone: TextInputEditText) {
//        val phoneValue = mobile.value!!.trim()
//        when {
//            isInputEmpty(phoneValue) -> showErrorEditText(_phone, R.string.phoneReq)
//            else -> {
//                hideSoftKeyboard(v)
//                viewModelScope.launch {
//                    repo.phoneRestTaskRepo(
//                        phoneValue,
//                        { isLoading.value = it },
//                        {
//                            navigate(
//                                v,
//                                R.id.action_ForgetPasswordFragment_to_ResetFragment,
//                                null,
//                                null,
//                                FragmentNavigatorExtras(_logo to "view")
//                            )
//                        },
//                        { messageId: Int, iconId: Int ->
//                            customSnackBar(
//                                v,
//                                v.context.getString(messageId),
//                                iconId
//                            ) {}
//                        })
//
//                }
//            }
    }


}
