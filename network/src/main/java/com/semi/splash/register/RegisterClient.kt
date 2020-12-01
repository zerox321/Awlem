package com.semi.splash.register

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RegisterClient @Inject constructor(private val service: RegisterService) {

    suspend fun registerTask(
        name: String,
        email: String,
        phone: String,
        password: String,
        device_token: String
    ) = withContext(Dispatchers.IO) {
        service.registerAsync(
            name = name,
            email = email,
            phone = phone,
            password = password,
            device_token = device_token
        ).await()
    }


}