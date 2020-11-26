package com.semi.awlem.ui.home.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentHomeBinding
import com.semi.entity.database.categoryController.CategoryEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.categoriesLiveData.collect { result: List<CategoryEntity> ->
                viewModel.categoryAdapter.submitList(
                    result
                )
            }
        }

    }

}


