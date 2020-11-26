package com.semi.awlem.ui.home.menu.help.common

import android.view.View
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.home.menu.help.HelpRepository
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.entity.response.menu.FaqResponse
import kotlinx.coroutines.launch

class CommonViewModel @ViewModelInject constructor(
    private val repository: HelpRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    val faq: FaqResponse? = savedStateHandle.get<FaqResponse>("faq")

    fun yesRateCommon(v: View) {
        rateCommon(v = v, helpfull = "1")
    }

    fun noRateCommon(v: View) {
        rateCommon(v = v, helpfull = "0")

    }

    private fun rateCommon(v: View, helpfull: String) {
        viewModelScope.launch {
            repository.rateFqaTaskRepo(
                faq_id = faq?.id.toString(),
                helpfull = helpfull,
                onLoading = { loading: Boolean -> _isLoading.value = loading },
                onFinish = { errorMessageId: Int, errorContent, icon: Int ->
                    val activity = v.context?.getActivity()
                    activity?.customSnackBar(
                        errorMessageId,
                        errorContent,
                        icon,
                    ) {}

                }

            )
        }
    }

}