package com.semi.awlem.ui.home.menu

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.entity.response.splash.LoginResponseData
import com.semi.entity.sharedPref.Pref
import com.semi.home.menu.profile.ProfileClient
import timber.log.Timber
import java.io.File
import javax.inject.Inject


class MenuRepository @Inject constructor(
    private val client: ProfileClient,
    private val pref: Pref
) : BaseRepository() {
    fun isNotUser() = pref.getUser() == null
    fun getUser() = pref.getUser()


    suspend fun updateUserPhotoTaskRepo(
        photoFile: File,
        onLoading: (Boolean) -> Unit,
        onSuccess: (LoginResponseData) -> Unit,
        onError: (String?, Int, Int) -> Unit

    ) {
        onLoading(true)
        Timber.tag(TAG).e("updateUserPhotoTaskRepo ")
        try {
            val response = client.updateUserPhotoTask(photoFile = photoFile)
            Timber.tag(TAG).e("updateUserPhotoTaskRepo response $response")
            response.data?.let {
                pref.saveUser(it)
                onSuccess(it)
            }
        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("updateUserPhotoTaskRepo error $throwable")
            onError("لا يوجد اتصال إنترنت ..", R.string.reload, R.drawable.ic_wifi_black_24dp)

        }
        onLoading(false)

    }


}