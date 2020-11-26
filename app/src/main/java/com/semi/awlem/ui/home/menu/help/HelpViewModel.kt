package com.semi.awlem.ui.home.menu.help

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
import com.semi.awlem.utility.showErrorSnackBar
import com.semi.entity.response.menu.FaqResponse
import kotlinx.coroutines.launch

class HelpViewModel @ViewModelInject constructor(
    private val repository: HelpRepository
) : BaseViewModel(), FaqsAdapter.ClickListener {
    val faqsAdapter = FaqsAdapter(this)
    val messageAddress = MutableLiveData<String>("")
    val content = MutableLiveData<String>("")

    init {
        getFaq(null)
    }

    fun getFaq(v: View?) {
        viewModelScope.launch {
            repository.getFaqTaskRepo(onLoading = { loading: Boolean ->
            },
                onSuccess = { list: List<FaqResponse>? ->
                    faqsAdapter.submitList(list)
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

        val messageAddressValue = messageAddress.value
        val contentValue = content.value
        when {
            isInputEmpty(messageAddressValue) -> showErrorSnackBar(
                activity = activity,
                editText = phoneTextInput,
                errorTitleId = R.string.phoneReq,
                errorMessageId = R.string.phoneReq,
                errorIconId = R.drawable.ic_phone_error
            )
            isInputEmpty(contentValue) -> showErrorSnackBar(
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

    override fun onItemClick(v: View, faq: FaqResponse) {
        v.findNavigationController().navigateTo(
            id = R.id.action_HelpFragment_to_CommonFragment,
            args = Bundle().apply {
                putParcelable("faq", faq)
            }
        )

    }
}