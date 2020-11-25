package com.semi.home.home

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeClient @Inject constructor(private val service: HomeService) {

    suspend fun getTypesTask() = withContext(Dispatchers.IO) {
        service.getTypesAsync().await()
    }


    suspend fun suggestedRestaurantsTask() = withContext(Dispatchers.IO) {
        service.suggestedRestaurantsAsync().await()
    }

    suspend fun suggestedProductsTask() = withContext(Dispatchers.IO) {
        service.suggestedProductsAsync().await()
    }


}