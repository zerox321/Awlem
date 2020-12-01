package com.semi.awlem.ui.splash.verification

import android.view.View
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.chaos.view.PinView
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.showErrorSnackBar

class VerificationViewModel @ViewModelInject constructor(
    private val repository: VerificationRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    private val token: String = savedStateHandle.get<String>("token") ?: ""

    fun activateClick(
        v: View,
        pin: PinView
    ) {
        val activity = v.context.getActivity()

        val code = pin.text!!.toString().trim()
        when {
            isInputEmpty(code) -> showErrorSnackBar(
                activity = activity,
                editText = pin,
                errorTitleId = R.string.phoneReq,
                errorMessageId = R.string.relog,
                errorIconId = R.drawable.ic_phone_error
            )

            else -> {
                v.hideKeyboard()
//                viewModelScope.launch {
//                    repository.activeAccountTaskRepo(
//                        Authorization = token,
//                        virification_code = code,
//                        onLoading = { loading: Boolean -> _isLoading.value = loading },
//                        onSuccess = {
//                            activity?.loadActivity(HomeActivity::class.java as Class<*>)
//                        },
//                        onError = { messageTitle: String?, messageContent: Int, icon: Int ->
//                            activity?.customSnackBar(
//                                title = messageTitle ?: "",
//                                message = messageContent,
//                                iconId = icon,
//                            ) {}
//                        })
//
//                }
            }

        }
    }

    fun onResendClick(v: View) {
        val activity = v.context.getActivity()
//        viewModelScope.launch {
//            repository.reSendCodeTaskRepo(
//                Authorization = token,
//                onLoading = { loading: Boolean -> _isLoading.value = loading },
//                onError = { messageTitle: String?, messageContent: Int, icon: Int ->
//                    activity?.customSnackBar(
//                        title = messageTitle ?: "",
//                        message = messageContent,
//                        iconId = icon,
//                    ) {}
//                })
//
//        }
    }

}