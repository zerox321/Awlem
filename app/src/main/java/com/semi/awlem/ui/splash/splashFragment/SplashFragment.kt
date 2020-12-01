package com.semi.awlem.ui.splash.splashFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.SplashFragmentBinding
import com.semi.awlem.ui.home.HomeActivity
import com.semi.awlem.ui.splash.verification.VerificationViewModel
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.NavigationUtil.navigateTo
import com.semi.awlem.utility.animation.AnimationView.setAnimationView
import com.semi.entity.sharedPref.Pref
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class SplashFragment : DataBindingFragment() {
    @Inject
    lateinit var pref: Pref

    @VisibleForTesting
    val viewModel by viewModels<VerificationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<SplashFragmentBinding>(
            inflater, R.layout.splash_fragment, container
        ).apply {
            logoTv.setAnimationView(
                animID = R.anim.fade,
                onAnimationEnd = {
                    val isUser = pref.getUser() != null
                    if (isUser)
                        loadHomeView()
                    else
                        navigateToWelcomeView()
                })

            lifecycleOwner = this@SplashFragment
            this.executePendingBindings()
        }.root
    }

    private fun loadHomeView() {
        val homeActivityClass = HomeActivity::class.java as Class<*>
        requireActivity().loadActivity(homeActivityClass)

    }

    private fun navigateToWelcomeView() {
        findNavController().navigateTo(
            id = R.id.action_SplashFragment_to_WelcomeFragment
        )

    }


}