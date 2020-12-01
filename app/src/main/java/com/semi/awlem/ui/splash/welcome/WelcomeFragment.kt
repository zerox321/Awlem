package com.semi.awlem.ui.splash.welcome

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentWelcomeBinding
import com.semi.awlem.ui.home.HomeActivity
import com.semi.awlem.utility.ActivitiesLauncher.loadActivity
import com.semi.awlem.utility.NavigationUtil.findNavigationController
import com.semi.awlem.utility.NavigationUtil.navigateTo

class WelcomeFragment : DataBindingFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentWelcomeBinding>(
            inflater, R.layout.fragment_welcome, container
        ).apply {
            skip.setOnClickListener {
                val homeActivityClass = HomeActivity::class.java as Class<*>
                requireActivity().loadActivity(homeActivityClass)
            }
            saveBt.setOnClickListener { v: View ->
                v.findNavigationController().navigateTo(
                    id = R.id.action_WelcomeFragment_to_LoginFragment,
                )
            }
            createAccount.setOnClickListener { v: View ->
                v.findNavigationController().navigateTo(
                    id = R.id.action_WelcomeFragment_to_RegisterFragment,
                )
            }
            lifecycleOwner = this@WelcomeFragment
            this.executePendingBindings()
        }.root
    }

}