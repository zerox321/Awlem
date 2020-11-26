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

    suspend fun rateFqaTaskRepo(
        faq_id: String,
        helpfull: String,
        onLoading: (Boolean) -> Unit,
        onFinish: (Int, Int, Int) -> Unit
    ) {
        onLoading(true)
        Timber.tag(TAG).e("rateFqaTaskRepo ")
        try {
            val response = client.rateFqaTask(faq_id = faq_id, helpfull = helpfull)
            Timber.tag(TAG).e("rateFqaTaskRepo response $response")
            val icon = R.drawable.ic_save_done
            onFinish(R.string.rate_done, R.string.thanks, icon)
        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("rateFqaTaskRepo error $throwable")
            val error = handleThrowable(throwable)
            val icon = R.drawable.ic_wifi_black_24dp
            onFinish(error, R.string.reload, icon)
            onLoading(false)

        }
    }

    suspend fun insertComplaintTaskRepo(
        name: String,
        body: String,
        onLoading: (Boolean) -> Unit,
        onFinish: (Int, Int, Int) -> Unit
    ) {
        onLoading(true)
        Timber.tag(TAG).e("insertComplaintTaskRepo ")
        try {
            val response = client.insertComplaintTask(name = name, body = body)
            Timber.tag(TAG).e("insertComplaintTaskRepo response $response")
            val icon = R.drawable.ic_save_done
            onFinish(R.string.rate_done, R.string.thanks, icon)
        } catch (throwable: Throwable) {
            Timber.tag(TAG).e("insertComplaintTaskRepo error $throwable")
            val error = handleThrowable(throwable)
            val icon = R.drawable.ic_wifi_black_24dp
            onFinish(error, R.string.reload, icon)
        }
        onLoading(false)

    }


}