package com.semi.awlem.ui.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container
        ).apply {
            viewModel = this@HomeFragment.viewModel
            lifecycleOwner = this@HomeFragment
            this.executePendingBindings()
        }.root
    }
}


