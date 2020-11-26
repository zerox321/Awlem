package com.semi.awlem.base

import android.os.Bundle
import android.view.View
import com.semi.awlem.ui.splash.SplashActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.dialog.LoginGuestDialog.showLoginGuestDialog

abstract class NoGuestFragment : DataBindingFragment() {

    private val user = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!user)
            requireContext().showLoginGuestDialog(onLoginClick = {
                val activityClass = SplashActivity::class.java as Class<*>
                val isGuest = true
                requireActivity().loadActivity(newActivityClass = activityClass, isGuest = isGuest)
            })

    }

}