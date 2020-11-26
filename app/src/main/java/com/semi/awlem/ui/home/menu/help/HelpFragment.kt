package com.semi.awlem.ui.home.menu.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.HelpFragmentBinding
import com.semi.entity.database.faqController.FaqEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.faqLiveData.collect { result: List<FaqEntity> ->
                viewModel.faqsAdapter.submitList(
                    result
                )
            }
        }

    }


}

