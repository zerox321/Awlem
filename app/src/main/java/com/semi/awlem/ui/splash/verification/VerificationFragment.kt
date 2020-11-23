package com.semi.awlem.ui.splash.verification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentVerificationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerificationFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<VerificationViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentVerificationBinding>(
            inflater, R.layout.fragment_verification, container
        ).apply {
            viewModel = this@VerificationFragment.viewModel
            lifecycleOwner = this@VerificationFragment
            this.executePendingBindings()
        }.root
    }


}