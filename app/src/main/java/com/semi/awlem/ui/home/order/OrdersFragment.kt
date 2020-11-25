package com.semi.awlem.ui.home.order

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentOrdersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrdersFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<OrdersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentOrdersBinding>(
            inflater, R.layout.fragment_orders, container
        ).apply {
            viewModel = this@OrdersFragment.viewModel
            lifecycleOwner = this@OrdersFragment
            this.executePendingBindings()
        }.root
    }


}