package com.semi.awlem.base

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.semi.awlem.utility.NavigationUtil.clearNavigateStack
import com.semi.awlem.utility.NavigationUtil.findNavigationController

open class BaseViewModel : ViewModel() {
    internal val TAG = javaClass.simpleName


    val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    val _isEmpty = MutableLiveData<Boolean>()
    val isEmpty: LiveData<Boolean> = _isEmpty


    fun onBack(v: View) {
        v.findNavigationController().clearNavigateStack()
    }


}
