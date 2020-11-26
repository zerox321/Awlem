package com.semi.awlem.ui.home.menu.staticPage

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.semi.awlem.base.BaseViewModel

class StaticViewModel @ViewModelInject constructor(
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val pageID: Int = savedStateHandle.get<Int>("pageID") ?: 0
    val pageTitle: String = savedStateHandle.get<String>("pageTitle") ?: ""

    val content = MutableLiveData<String>().apply {
        value = "$pageTitle $pageID"
    }


}