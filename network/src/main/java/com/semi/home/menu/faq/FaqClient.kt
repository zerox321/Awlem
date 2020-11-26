package com.semi.home.menu.faq

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FaqClient @Inject constructor(private val service: FaqService) {

    suspend fun getFaqTask() = withContext(Dispatchers.IO) {
        service.getFaqAsync().await()
    }

    suspend fun rateFqaTask(faq_id: String, helpfull: String) = withContext(Dispatchers.IO) {
        service.rateFqaAsync(faq_id = faq_id, helpfull = helpfull).await()
    }


}