package com.semi.awlem.ui.home.menu.rate


import android.view.View
import android.widget.RatingBar
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.material.textfield.TextInputEditText
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.splash.SplashActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.awlem.utility.dialog.LoginGuestDialog.showLoginGuestDialog
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.showErrorSnackBar
import kotlinx.coroutines.launch

class RateViewModel @ViewModelInject constructor(
    private val repository: RateRepository
) : BaseViewModel() {


    val content = MutableLiveData<String>("")
    fun sendClick(
        v: View,
        rate: RatingBar,
        passwordTextInput: TextInputEditText
    ) {
        val activity = v.context.getActivity()

        val rateValue = rate.rating.toString()
        val contentValue = content.value ?: ""

        when {
            repository.isNotUser() -> activity?.showLoginGuestDialog(
                isCancelable = true,
                onLoginClick = {
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
                    repository.ratingApTaskRepo(
                        rate = rateValue,
                        review = contentValue,
                        onLoading = { loading: Boolean -> _isLoading.value = loading },
                        onSuccess = {
                            activity?.customSnackBar(
                                R.string.rate_done,
                                R.string.thanks,
                                R.drawable.ic_save_done,
                            ) { onBack(v) }
                        },
                        onError = { errorMessageId: String?, errorContent, icon: Int ->
                            activity?.customSnackBar(
                                errorMessageId ?: "",
                                errorContent,
                                icon,
                            ) {}
                        })
                }
            }
        }
    }

}