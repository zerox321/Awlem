package com.semi.awlem.ui.home.menu.staticPage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.StaticFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StaticFragment : DataBindingFragment() {
    @VisibleForTesting
    val viewModel by viewModels<StaticViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<StaticFragmentBinding>(
            inflater, R.layout.static_fragment, container
        ).apply {
            viewModel = this@StaticFragment.viewModel
            lifecycleOwner = this@StaticFragment
            this.executePendingBindings()
        }.root
    }


}
