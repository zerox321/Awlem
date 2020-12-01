package com.semi.awlem.ui.home.menu

import android.os.Bundle
import android.view.View
import com.semi.awlem.R
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.splash.SplashActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.ContextConverter.getActivity
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.dialog.ImageSelectorUtil.showImageSelectorDialog
import com.semi.awlem.utility.dialog.LogoutDialog.showLogoutDialog
import java.io.File

class MenuViewModel : BaseViewModel() {
    fun onProfileClick(v: View) {
        val activity = v.context.getActivity()
        activity?.showImageSelectorDialog(onSuccess = { file: File? -> })

    }

    fun onLogoutClick(v: View) {
        val activity = v.context.getActivity()
        activity?.showLogoutDialog(onLogoutClick = {
            val splashActivity = SplashActivity::class.java as Class<*>
            activity.loadActivity(splashActivity)
        })

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