package com.semi.awlem.ui.home.menu.help

import android.os.Bundle
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.entity.response.menu.FaqResponse
import kotlinx.coroutines.async

class HelpViewModel @ViewModelInject constructor(
    private val repository: HelpRepository
) : BaseViewModel(), FaqsAdapter.ClickListener {
    val faqsAdapter = FaqsAdapter(this)

    init {
        getFaq(null)
    }

    fun getFaq(v: View?) {
        viewModelScope.async {
            repository.getFaqTaskRepo(onLoading = { loading: Boolean ->
                _isLoading.value = loading
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

    override fun onItemClick(v: View, faq: FaqResponse) {
        v.findNavigationController().navigateTo(
            id = R.id.action_HelpFragment_to_CommonFragment,
            args = Bundle().apply {
                putParcelable("faq", faq)
            }
        )

    }
}