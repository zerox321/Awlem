package com.semi.awlem.ui.home.offers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentOffersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OffersFragment : DataBindingFragment() {

    @VisibleForTesting
    val viewModel by viewModels<OffersViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentOffersBinding>(
            inflater, R.layout.fragment_offers, container
        ).apply {
            viewModel = this@OffersFragment.viewModel
            lifecycleOwner = this@OffersFragment
            this.executePendingBindings()
        }.root
    }

}
