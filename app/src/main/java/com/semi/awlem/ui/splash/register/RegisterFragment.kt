package com.semi.awlem.ui.splash.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentRegisterationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : DataBindingFragment() {
    @VisibleForTesting
    val viewModel by viewModels<RegisterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentRegisterationBinding>(
            inflater, R.layout.fragment_registeration, container
        ).apply {
            viewModel = this@RegisterFragment.viewModel
            lifecycleOwner = this@RegisterFragment
            this.executePendingBindings()
        }.root
    }


}
