package com.semi.home.offer

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class OfferClient @Inject constructor(private val service: OfferService) {

    suspend fun restorantsHasOffersTask(page: String) = withContext(Dispatchers.IO) {
        service.restorantsHasOffersAsync(page = page).await()
    }


}