package com.semi.awlem.ui.splash.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.semi.awlem.R
import com.semi.awlem.base.DataBindingFragment
import com.semi.awlem.databinding.FragmentWelcomeBinding


class WelcomeFragment : DataBindingFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding<FragmentWelcomeBinding>(
            inflater, R.layout.fragment_welcome, container
        ).apply {
            lifecycleOwner = this@WelcomeFragment
            this.executePendingBindings()
        }.root
    }


}