package com.semi.awlem.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionInflater
import com.semi.awlem.utility.KeyboardUtil.hideKeyboard

abstract class DataBindingFragment : Fragment() {
    internal val TAG = javaClass.simpleName

    protected inline fun <reified T : ViewDataBinding> binding(
        inflater: LayoutInflater,
        @LayoutRes resId: Int,
        container: ViewGroup?
    ): T = DataBindingUtil.inflate(inflater, resId, container, false)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val animation =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation

    }

    override fun onDestroyView() {
        super.onDestroyView()
        val view = requireActivity().currentFocus ?: return
        view.hideKeyboard()
    }

    protected fun recyclerViewOnPreDraw(rv: RecyclerView) {
        rv.apply {
            this.adapter = adapter
            postponeEnterTransition()
            viewTreeObserver.addOnPreDrawListener {
                startPostponedEnterTransition()
                true
            }
        }
    }

}