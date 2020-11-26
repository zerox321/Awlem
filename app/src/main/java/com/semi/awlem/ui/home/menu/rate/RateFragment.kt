package com.semi.awlem.ui.home.menu.rate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.RateFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RateFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<RateViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<RateFragmentBinding>(
            inflater, R.layout.rate_fragment, container
        ).apply {
            viewModel = this@RateFragment.viewModel
            lifecycleOwner = this@RateFragment
            this.executePendingBindings()
        }.root
    }


}
