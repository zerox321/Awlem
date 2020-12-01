package com.semi.awlem.ui.splash.register

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.entity.sharedPref.Pref
import com.semi.splash.register.RegisterClient
import timber.log.Timber
import javax.inject.Inject


class RegisterRepository @Inject constructor(
    private val client: RegisterClient,
    private val pref: Pref
) : BaseRepository() {


    suspend fun registerTaskRepo(
        name: String,
        email: String,
        phone: String,
        password: String,
        onLoading: (Boolean) -> Unit,
        onActivate: (String?) -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)
        val deviceToken = pref.getNotificationToken()

        Timber.tag(TAG).e("registerTaskRepo ")
        try {
            val response =
                client.registerTask(
                    name = name,
                    email = email,
                    phone = phone,
                    password = password,
                    device_token = deviceToken
                )
            Timber.tag(TAG).e("registerTaskRepo response $response")
            when (response.success) {
                true -> {
                    onActivate(response.data?.token)
                }
                else -> {
                    onError(response.data?.error, R.string.re_regiter, R.drawable.ic_user_error)
                    onLoading(false)
                }
            }

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("registerTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.re_regiter, R.drawable.ic_wifi_black_24dp)

            onLoading(false)
        }
    }


}