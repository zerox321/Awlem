package com.semi.awlem.ui.home.menu.help

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.entity.response.menu.FaqResponse
import kotlinx.coroutines.async

class HelpViewModel @ViewModelInject constructor(
    private val repository: HelpRepository
) : BaseViewModel() {

    init {
        getFaq(null)
    }

    fun getFaq(v: View?) {
        viewModelScope.async {
            repository.getFaqTaskRepo(onLoading = { loading: Boolean ->
                _isLoading.value = loading
            },
                onSuccess = { list: List<FaqResponse>? ->

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
}