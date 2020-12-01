package com.semi.awlem.ui.home.menu.help.common

import android.view.View
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.home.menu.help.HelpRepository
import com.semi.awlem.ui.splash.SplashActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.entity.database.faqController.FaqEntity
import kotlinx.coroutines.launch

class CommonViewModel @ViewModelInject constructor(
    private val repository: HelpRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    val faq: FaqEntity? = savedStateHandle.get<FaqEntity>("faq")

    fun yesRateCommon(v: View) {
        rateCommon(v = v, helpfull = "1")
    }

    fun noRateCommon(v: View) {
        rateCommon(v = v, helpfull = "0")

    }

    private fun rateCommon(v: View, helpfull: String) {
        val activity = v.context?.getActivity()

        if (repository.isNotUser()) {
            val activityClass = SplashActivity::class.java as Class<*>
            val isGuest = true
            activity?.loadActivity(newActivityClass = activityClass, isGuest = isGuest)
        } else
            viewModelScope.launch {
                repository.rateFqaTaskRepo(
                    faq_id = faq?.id.toString(),
                    helpfull = helpfull,
                    onLoading = { loading: Boolean -> _isLoading.value = loading },
                    onFinish = { errorMessageId: Int, errorContent, icon: Int ->
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