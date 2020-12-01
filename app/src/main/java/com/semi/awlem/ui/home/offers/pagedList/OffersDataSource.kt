package com.semi.awlem.ui.home.offers.pagedList

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.semi.awlem.ui.home.offers.OffersRepository
import com.semi.entity.response.offer.OfferResponseData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class OffersDataSource(
    private val viewModelScope: CoroutineScope,
    private val repo: OffersRepository,
    private val loading: MutableLiveData<Boolean>,
    private val isEmpty: MutableLiveData<Boolean>

) : PageKeyedDataSource<Int, OfferResponseData>() {
    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, OfferResponseData>
    ) {
        viewModelScope.launch {
            repo.restorantsHasOffersTaskRepo(
                page = params.key.toString(),
                onLoading = { loading.value = it },
                onSuccess = { response ->
                    val key = if (params.key > 1) params.key - 1 else 0
                    response?.data?.let { callback.onResult(it, key) }
                },
                onError = { s: String?, i: Int, icon: Int -> })

        }

    }

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, OfferResponseData>
    ) {
        viewModelScope.launch {
            repo.restorantsHasOffersTaskRepo(
                page = FIRST_PAGE.toString(),
                onLoading = { loading.value = it },
                onSuccess = { response ->
                    isEmpty.value =
                        response?.data == null || response.data!!.isEmpty()
                    response?.data?.let {
                        callback.onResult(
                            it,
                            null,
                            FIRST_PAGE + 1
                        )
                    }

                }, onError = { s: String?, i: Int, icon: Int -> })


        }

    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, OfferResponseData>
    ) {
        viewModelScope.launch {
            repo.restorantsHasOffersTaskRepo(params.key.toString(),
                onLoading = {},
                onSuccess = { response ->
                    response?.data?.let { callback.onResult(it, params.key + 1) }

                }, onError = { s: String?, i: Int, icon: Int -> })


        }


    }

    companion object {
        const val PAGE_SIZE = 10
        const val FIRST_PAGE = 1
    }
}