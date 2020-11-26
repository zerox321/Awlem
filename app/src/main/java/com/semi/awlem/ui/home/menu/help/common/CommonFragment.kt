package com.semi.awlem.ui.home.menu.help.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.CommonFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CommonFragment : DataBindingFragment() {
    @VisibleForTesting
    val viewModel by viewModels<CommonViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<CommonFragmentBinding>(
            inflater, R.layout.common_fragment, container
        ).apply {
            viewModel = this@CommonFragment.viewModel
            lifecycleOwner = this@CommonFragment
            this.executePendingBindings()
        }.root
    }


}

