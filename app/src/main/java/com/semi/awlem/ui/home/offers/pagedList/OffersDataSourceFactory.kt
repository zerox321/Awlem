package com.semi.awlem.ui.home.offers.pagedList

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.semi.awlem.ui.home.offers.OffersRepository
import com.semi.entity.response.offer.OfferResponseData
import kotlinx.coroutines.CoroutineScope

class OffersDataSourceFactory(
    private val viewModelScope: CoroutineScope,
    private val repo: OffersRepository,
    private val loading: MutableLiveData<Boolean>,
    private val isEmpty: MutableLiveData<Boolean>
) : DataSource.Factory<Int, OfferResponseData>() {
    private val userLiveDataSource = MutableLiveData<OffersDataSource>()
    override fun create(): DataSource<Int, OfferResponseData> {
        val userDataSource =
            OffersDataSource(viewModelScope, repo, loading, isEmpty)
        userLiveDataSource.postValue(userDataSource)
        return userDataSource
    }

    fun invalidate() {
        userLiveDataSource.value?.invalidate()
    }


}