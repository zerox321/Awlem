package com.semi.awlem.ui.home.menu.rate

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.entity.sharedPref.Pref
import com.semi.home.menu.rate.RateClient
import timber.log.Timber
import javax.inject.Inject


class RateRepository @Inject constructor(
    private val client: RateClient,
    private val pref: Pref
) : BaseRepository() {
    fun isNotUser() = pref.getUser() == null


    suspend fun ratingApTaskRepo(
        rate: String, review: String,
        onLoading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)
        Timber.tag(TAG).e("ratingApTaskRepo ")
        try {
            val response = client.ratingApTask(rate = rate, review = review)
            Timber.tag(TAG).e("ratingApTaskRepo response $response")
            onSuccess()
        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("ratingApTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.re_activate, R.drawable.ic_wifi_black_24dp)
            onLoading(false)

        }

    }


}