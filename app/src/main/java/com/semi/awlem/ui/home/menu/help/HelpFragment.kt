package com.semi.awlem.ui.home.menu.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.HelpFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HelpFragment : DataBindingFragment() {
    @VisibleForTesting
    val viewModel by viewModels<HelpViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<HelpFragmentBinding>(
            inflater, R.layout.help_fragment, container
        ).apply {
            viewModel = this@HelpFragment.viewModel
            lifecycleOwner = this@HelpFragment
            this.executePendingBindings()
        }.root
    }


}

