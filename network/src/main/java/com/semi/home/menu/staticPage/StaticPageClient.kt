package com.semi.home.menu.staticPage

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StaticPageClient @Inject constructor(private val service: StaticPageService) {

    suspend fun getPageTask() = withContext(Dispatchers.IO) {
        service.getPageAsync().await()
    }


}