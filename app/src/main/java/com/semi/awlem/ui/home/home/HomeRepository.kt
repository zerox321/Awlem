package com.semi.awlem.ui.home.home

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.awlem.utility.handleThrowable
import com.semi.entity.response.home.CategoryResponse
import com.semi.entity.response.home.SuggestedProducts
import com.semi.entity.response.home.SuggestedRestaurantsResponse
import com.semi.home.home.HomeClient
import timber.log.Timber
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val client: HomeClient
) : BaseRepository() {


    suspend fun getTypesTaskRepo(
        onLoading: (Boolean) -> Unit,
        onSuccess: (List<CategoryResponse>?) -> Unit,
        onError: (Int, Int, Int) -> Unit

    ) {
        onLoading(true)
        Timber.tag(TAG).e("getTypesTaskRepo ")
        try {
            val response = client.getTypesTask()
            Timber.tag(TAG).e("getTypesTaskRepo response $response")
            onSuccess(response)

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("getTypesTaskRepo error $throwable")
            val error = handleThrowable(throwable)
            val icon = R.drawable.ic_wifi_black_24dp
            onError(error, R.string.reload, icon)
        }
        onLoading(false)

    }

    suspend fun suggestedRestaurantsTaskRepo(
        onLoading: (Boolean) -> Unit,
        onSuccess: (List<SuggestedRestaurantsResponse>?) -> Unit,
        onError: (Int, Int, Int) -> Unit

    ) {
        onLoading(true)
        Timber.tag(TAG).e("suggestedRestaurantsTaskRepo ")
        try {
            val response = client.suggestedRestaurantsTask()
            Timber.tag(TAG).e("suggestedRestaurantsTaskRepo response $response")
            onSuccess(response)

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("suggestedRestaurantsTaskRepo error $throwable")
            val error = handleThrowable(throwable)
            val icon = R.drawable.ic_wifi_black_24dp
            onError(error, R.string.reload, icon)
        }
        onLoading(false)
    }

    suspend fun suggestedProductsTaskRepo(
        onLoading: (Boolean) -> Unit,
        onSuccess: (List<SuggestedProducts>?) -> Unit,
        onError: (Int, Int, Int) -> Unit

    ) {
        onLoading(true)
        Timber.tag(TAG).e("suggestedProductsTaskRepo ")
        try {
            val response = client.suggestedProductsTask()
            Timber.tag(TAG).e("suggestedProductsTaskRepo response $response")
            onSuccess(response)

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("suggestedProductsTaskRepo error $throwable")
            val error = handleThrowable(throwable)
            val icon = R.drawable.ic_wifi_black_24dp
            onError(error, R.string.reload, icon)
        }
        onLoading(false)
    }

}