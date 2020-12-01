package com.semi.awlem.ui.home.menu.rate


import android.view.View
import android.widget.RatingBar
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.splash.SplashActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard
import com.semi.awlem.utility.dialog.LoginGuestDialog.showLoginGuestDialog
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.showErrorSnackBar
import kotlinx.coroutines.launch

class RateViewModel : BaseViewModel() {

    private val isNoTUser = false

    val content = MutableLiveData<String>("")
    fun sendClick(
        v: View,
        rate: RatingBar,
        passwordTextInput: TextInputEditText
    ) {
        val activity = v.context.getActivity()

        val contentValue = content.value ?: ""
        val rateValue = rate.rating.toString()
        when {
            isNoTUser -> activity?.showLoginGuestDialog(isCancelable = true, onLoginClick = {
                val activityClass = SplashActivity::class.java as Class<*>
                val isGuest = true
                activity.loadActivity(newActivityClass = activityClass, isGuest = isGuest)
            })

            isInputEmpty(contentValue) -> showErrorSnackBar(
                activity = activity,
                editText = passwordTextInput,
                errorTitleId = R.string.message_content_req,
                errorMessageId = R.string.resend,
                errorIconId = R.drawable.ic_code_error
            )

            else -> {
                v.hideKeyboard()
                viewModelScope.launch {
//                    repository.insertComplaintTaskRepo(
//                        name = messageAddressValue,
//                        body = contentValue,
//                        onLoading = { loading: Boolean -> _isLoading.value = loading },
//                        onFinish = { errorMessageId: Int, errorContent, icon: Int ->
//                            activity?.customSnackBar(
//                                errorMessageId,
//                                errorContent,
//                                icon,
//                            ) {}
//                        })
                }
            }
        }
    }

}