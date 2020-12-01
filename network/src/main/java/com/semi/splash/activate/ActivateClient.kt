package com.semi.splash.activate

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ActivateClient @Inject constructor(private val service: ActivateService) {

    suspend fun activeAccountTask(
        Authorization: String, virification_code: String
    ) = withContext(Dispatchers.IO) {
        service.activeAccountAsync(
            Authorization = Authorization,
            virification_code = virification_code
        ).await()
    }

    suspend fun reSendCodeTask(
        Authorization: String
    ) = withContext(Dispatchers.IO) {
        service.reSendCodeAsync(
            Authorization = Authorization
        ).await()
    }


}