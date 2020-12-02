package com.semi.awlem.ui.home.menu

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.splash.SplashActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.SnackBar.customSnackBar
import com.semi.awlem.utility.dialog.ImageSelectorUtil.showImageSelectorDialog
import com.semi.awlem.utility.dialog.LogoutDialog.showLogoutDialog
import com.semi.entity.response.splash.LoginResponseData
import kotlinx.coroutines.launch
import java.io.File

class MenuViewModel @ViewModelInject constructor(private val repository: MenuRepository) :
    BaseViewModel() {
    val isNotUser = repository.isNotUser()
    val userData = MutableLiveData<LoginResponseData?>(repository.getUser())
    fun onProfileClick(v: View) {
        if (isNotUser) return
        val activity = v.context.getActivity()
        activity?.showImageSelectorDialog(onSuccess = { file: File? ->
            file?.let { activity.uploadImage(it) }
        })

    }

    private fun Activity.uploadImage(file: File) {
        viewModelScope.launch {
            repository.updateUserPhotoTaskRepo(
                photoFile = file,
                onLoading = { loading -> _isLoading.value = loading },
                onSuccess = { user ->
                    userData.value = user
                },
                onError = { messageTitle: String?, messageContent: Int, icon: Int ->
                    customSnackBar(
                        title = messageTitle ?: "",
                        message = messageContent,
                        iconId = icon,
                    ) {}
                })
        }

    }

    fun onLogoutClick(v: View) {
        val activity = v.context.getActivity()
        activity?.showLogoutDialog(onLogoutClick = {
            repository.logout()
            val splashActivity = SplashActivity::class.java as Class<*>
            activity.loadActivity(splashActivity)
        })

    }

    fun onLoginClick(v: View) {
        val activity = v.context.getActivity()
        val splashActivity = SplashActivity::class.java as Class<*>
        activity?.loadActivity(splashActivity, isGuest = true)

    }

    fun staticClick(v: View, pageTitle: String, pageID: Int) {
        v.findNavigationController().navigateTo(
            id = R.id.action_navigation_more_to_StaticPageFragment,
            args = Bundle().apply {
                putInt("pageID", pageID)
                putString("pageTitle", pageTitle)
            }
        )

    }

    fun helpClick(v: View) {
        v.findNavigationController().navigateTo(
            id = R.id.action_navigation_more_to_HelpFragment
        )

    }

    fun rateClick(v: View) {
        v.findNavigationController().navigateTo(
            id = R.id.action_navigation_more_to_RateFragment
        )

    }

}