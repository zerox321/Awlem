package com.semi.awlem.ui.home.offers

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.semi.awlem.base.BaseViewModel
import com.semi.awlem.ui.home.offers.pagedList.OffersAdapter
import com.semi.awlem.ui.home.offers.pagedList.OffersDataSource
import com.semi.awlem.ui.home.offers.pagedList.OffersDataSourceFactory
import com.semi.entity.response.offer.OfferResponseData

class OffersViewModel @ViewModelInject constructor(private val repository: OffersRepository) :
    BaseViewModel(), OffersAdapter.ClickListener {

    val name = "مرحبا بك " + repository.pref.getUser()?.name

    val adapter = OffersAdapter(this)

    private val itemDataSourceFactory =
        OffersDataSourceFactory(viewModelScope, repository, _isLoading, _isEmpty)


    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPageSize(OffersDataSource.PAGE_SIZE)
        .build()

    val pagedList: LiveData<PagedList<OfferResponseData>> by lazy {
        LivePagedListBuilder(itemDataSourceFactory, config)
            .build()
    }


    fun onRefresh() {
        itemDataSourceFactory.invalidate()
    }

    override fun onRowClick(v: View, offer: OfferResponseData) {

    }

}