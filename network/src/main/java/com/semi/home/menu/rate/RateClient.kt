package com.semi.home.menu.rate

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RateClient @Inject constructor(private val service: RateService) {

    suspend fun ratingApTask(
        rate: String, review: String
    ) = withContext(Dispatchers.IO) {
        service.ratingApAsync(
            rate = rate,
            review = review
        ).await()
    }


}