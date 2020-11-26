package com.semi.awlem.ui.home.menu.staticPage

import com.semi.awlem.base.BaseRepository
import com.semi.entity.sharedPref.Pref
import com.semi.home.menu.staticPage.StaticPageClient
import timber.log.Timber
import javax.inject.Inject


class StaticRepository @Inject constructor(
    private val client: StaticPageClient,
    private val pref: Pref
) : BaseRepository() {

    fun getContent(key: String) = pref.getStr(key)
    private fun saveContent(key: String) = pref.getStr(key)

    suspend fun getPageTaskRepo(
        id: Int,
        key: String,
        onSuccess: (String?) -> Unit
    ) {
        Timber.tag(TAG).e("getPageTaskRepo ")
        try {
            val response = client.getPageTask()
            Timber.tag(TAG).e("getPageTaskRepo response $response")
            onSuccess(response.body)
            saveContent(key)

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("getPageTaskRepo error $throwable")

        }
    }


}