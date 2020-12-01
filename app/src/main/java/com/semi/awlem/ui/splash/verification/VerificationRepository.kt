package com.semi.awlem.ui.splash.verification

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.entity.sharedPref.Pref
import com.semi.splash.activate.ActivateClient
import timber.log.Timber
import javax.inject.Inject


class VerificationRepository @Inject constructor(
    private val client: ActivateClient,
    private val pref: Pref
) : BaseRepository() {


    suspend fun activeAccountTaskRepo(
        Authorization: String,
        virification_code: String,
        onLoading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)

        Timber.tag(TAG).e("activeAccountTaskRepo ")
        try {
            val response =
                client.activeAccountTask(
                    Authorization = "Bearer $Authorization",
                    virification_code = virification_code
                )
            Timber.tag(TAG).e("activeAccountTaskRepo response $response")
            when (response.success) {
                true -> {
                    response.data?.let { data -> pref.saveUser(data) }
                    onSuccess()
                }
                else -> {
                    onError(response.data?.error, R.string.re_activate, R.drawable.ic_code_error)
                    onLoading(false)
                }
            }

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("activeAccountTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.re_activate, R.drawable.ic_wifi_black_24dp)

            onLoading(false)
        }
    }

    suspend fun reSendCodeTaskRepo(
        Authorization: String,
        onLoading: (Boolean) -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)
        Timber.tag(TAG).e("activeAccountTaskRepo ")
        try {
            val response = client.reSendCodeTask(Authorization = "Bearer $Authorization")
            Timber.tag(TAG).e("activeAccountTaskRepo response $response")
        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("activeAccountTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.re_activate, R.drawable.ic_wifi_black_24dp)

        }
        onLoading(false)

    }


}