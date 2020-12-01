package com.semi.awlem.ui.splash.login

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.entity.sharedPref.Pref
import com.semi.splash.login.LoginClient
import timber.log.Timber
import javax.inject.Inject


class LoginRepository @Inject constructor(
    private val client: LoginClient,
    private val pref: Pref
) : BaseRepository() {


    suspend fun loginTaskRepo(
        phone: String, password: String,
        onLoading: (Boolean) -> Unit,
        onSuccess: () -> Unit,
        onActivate: (String?) -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)
        val deviceToken = pref.getNotificationToken()

        Timber.tag(TAG).e("loginTaskRepo ")
        try {
            val response =
                client.loginTask(phone = phone, password = password, device_token = deviceToken)
            Timber.tag(TAG).e("loginTaskRepo response $response")
            when {
                response.success == true -> {
                    response.data?.let { data -> pref.saveUser(data) }
                    onSuccess()
                }
                response.data?.active == 0 -> {
                    onActivate(response.data?.token)
                }
                else -> {
                    onError(response.data?.error, R.string.relog, R.drawable.ic_user_error)
                    onLoading(false)

                }
            }

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("loginTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.relog, R.drawable.ic_wifi_black_24dp)

            onLoading(false)
        }
    }


}