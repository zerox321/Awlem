package com.semi.awlem.ui.home.menu.help

import com.semi.awlem.R
import com.semi.awlem.base.BaseRepository
import com.semi.awlem.utility.handleThrowable
import com.semi.entity.response.menu.FaqResponse
import com.semi.home.menu.faq.FaqClient
import timber.log.Timber
import javax.inject.Inject


class HelpRepository @Inject constructor(
    private val client: FaqClient
) : BaseRepository() {


    suspend fun getFaqTaskRepo(
        onLoading: (Boolean) -> Unit,
        onSuccess: (List<FaqResponse>?) -> Unit,
        onError: (Int, Int, Int) -> Unit

    ) {
        onLoading(true)

        Timber.tag(TAG).e("getFaqTaskRepo ")
        try {
            val response = client.getFaqTask()
            Timber.tag(TAG).e("getFaqTaskRepo response $response")
            onSuccess(response)

        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("getFaqTaskRepo error $throwable")
            val error = handleThrowable(throwable)
            val icon = R.drawable.ic_wifi_black_24dp
            onError(error, R.string.reload, icon)
        }
        onLoading(false)

    }


}