package com.semi.awlem.ui.home.menu.help.common

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.home.menu.staticPage.StaticRepository
import com.semi.entity.response.menu.FaqResponse

class CommonViewModel @ViewModelInject constructor(
    private val repository: StaticRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
) : BaseViewModel() {
    val Faq: FaqResponse? = savedStateHandle.get<FaqResponse>("faq")


}