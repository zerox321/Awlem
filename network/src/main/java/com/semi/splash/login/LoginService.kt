package com.semi.splash.login

import com.semi.entity.response.splash.LoginResponse
import com.semi.network.EndPoint.loginConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface LoginService {

    @FormUrlEncoded
    @POST(loginConstant)
    fun loginAsync(
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("device_token") device_token: String
    ): Deferred<LoginResponse>


}