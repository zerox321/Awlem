package com.semi.splash.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LoginClient @Inject constructor(private val service: LoginService) {

    suspend fun loginTask(
        phone: String, password: String, device_token: String
    ) = withContext(Dispatchers.IO) {
        service.loginAsync(phone = phone, password = password, device_token = device_token).await()
    }


}