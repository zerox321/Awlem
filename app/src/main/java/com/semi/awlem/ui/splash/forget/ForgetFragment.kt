package com.semi.awlem.ui.splash.forget

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.ForgetFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForgetFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<ForgetViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<ForgetFragmentBinding>(
            inflater, R.layout.forget_fragment, container
        ).apply {
            viewModel = this@ForgetFragment.viewModel
            lifecycleOwner = this@ForgetFragment
            this.executePendingBindings()
        }.root
    }


}
