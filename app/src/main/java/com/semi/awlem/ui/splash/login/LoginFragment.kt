package com.semi.awlem.ui.splash.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentLoginBinding>(
            inflater, R.layout.fragment_login, container
        ).apply {
            viewModel = this@LoginFragment.viewModel
            lifecycleOwner = this@LoginFragment
            this.executePendingBindings()
        }.root
    }


}