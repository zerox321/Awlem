package com.semi.awlem.ui.home.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentMenuBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MenuFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<MenuViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentMenuBinding>(
            inflater, R.layout.fragment_menu, container
        ).apply {
            viewModel = this@MenuFragment.viewModel
            lifecycleOwner = this@MenuFragment
            this.executePendingBindings()
        }.root
    }


}
