package com.semi.awlem.ui.home.offers

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.entity.response.offer.OfferResponse
import com.semi.entity.sharedPref.Pref
import com.semi.home.offer.OfferClient
import timber.log.Timber
import javax.inject.Inject


class OffersRepository @Inject constructor(
    private val client: OfferClient,
    val pref: Pref
) : BaseRepository() {

    suspend fun restorantsHasOffersTaskRepo(
        page: String,
        onLoading: (Boolean) -> Unit,
        onSuccess: (OfferResponse?) -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)

        Timber.tag(TAG).e("restorantsHasOffersTaskRepo ")
        try {
            val response =
                client.restorantsHasOffersTask(page = page)
            Timber.tag(TAG).e("restorantsHasOffersTaskRepo response $response")
            onSuccess(response)

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("restorantsHasOffersTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.reload, R.drawable.ic_wifi_black_24dp)

        }
        onLoading(false)

    }


}