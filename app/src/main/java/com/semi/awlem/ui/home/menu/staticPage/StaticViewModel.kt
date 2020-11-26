package com.semi.awlem.ui.home.menu.staticPage

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.semi.awlem.base.BaseViewModel
import kotlinx.coroutines.launch

class StaticViewModel @ViewModelInject constructor(
    private val repository: StaticRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {

    private val pageID: Int = savedStateHandle.get<Int>("pageID") ?: 0
    val pageTitle: String = savedStateHandle.get<String>("pageTitle") ?: ""
    private val savedKey = "$pageTitle $pageID"

    val content = MutableLiveData<String>().apply {
        value = repository.getContent(savedKey)
    }

    init {
        getPage()
    }

    private fun getPage() {
        viewModelScope.launch {
            repository.getPageTaskRepo(id = pageID, key = savedKey, onSuccess = { result: String? ->
                content.value = result
            })
        }
    }

}