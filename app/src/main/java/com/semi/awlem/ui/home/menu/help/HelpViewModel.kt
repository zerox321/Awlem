package com.semi.awlem.ui.home.menu.help

import android.os.Bundle
import android.view.View
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
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.awlem.utility.dialog.LoginGuestDialog.showLoginGuestDialog
import com.semi.awlem.utility.isInputEmpty
import com.semi.awlem.utility.showErrorSnackBar
import com.semi.entity.database.faqController.FaqEntity
import kotlinx.coroutines.launch

class HelpViewModel @ViewModelInject constructor(
    private val repository: HelpRepository
) : BaseViewModel(), FaqsAdapter.ClickListener {
    val isNoTUser = true
    val faqsAdapter = FaqsAdapter(this)
    val messageAddress = MutableLiveData<String>("")
    val content = MutableLiveData<String>("")


    val faqLiveData = repository.getFaqLiveData()

    init {
        getFaq(null)
    }

    fun getFaq(v: View?) {
        viewModelScope.launch {
            repository.getFaqTaskRepo(
                onLoading = { loading: Boolean ->
                },
                onError = { errorMessageId: Int, errorContent, icon: Int ->
                    val activity = v?.context?.getActivity()
                    activity?.customSnackBar(
                        errorMessageId,
                        errorContent,
                        icon,
                    ) {}
                })
        }
    }

    fun loginClick(
        v: View,
        phoneTextInput: TextInputEditText,
        passwordTextInput: TextInputEditText
    ) {
        val activity = v.context.getActivity()

        val messageAddressValue = messageAddress.value ?: ""
        val contentValue = content.value ?: ""
        when {
            isNoTUser -> activity?.showLoginGuestDialog(isCancelable = true, onLoginClick = {
                val activityClass = SplashActivity::class.java as Class<*>
                val isGuest = true
                activity.loadActivity(newActivityClass = activityClass, isGuest = isGuest)
            })
            isInputEmpty(messageAddressValue) -> showErrorSnackBar(
                activity = activity,
                editText = phoneTextInput,
                errorTitleId = R.string.message_address_req,
                errorMessageId = R.string.resend,
                errorIconId = R.drawable.ic_code_error
            )
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
                    repository.insertComplaintTaskRepo(
                        name = messageAddressValue,
                        body = contentValue,
                        onLoading = { loading: Boolean -> _isLoading.value = loading },
                        onFinish = { errorMessageId: Int, errorContent, icon: Int ->
                            activity?.customSnackBar(
                                errorMessageId,
                                errorContent,
                                icon,
                            ) {}
                        })
                }
            }
        }
    }

    override fun onItemClick(v: View, faq: FaqEntity) {
        v.findNavigationController().navigateTo(
            id = R.id.action_HelpFragment_to_CommonFragment,
            args = Bundle().apply {
                putParcelable("faq", faq)
            }
        )

    }
}