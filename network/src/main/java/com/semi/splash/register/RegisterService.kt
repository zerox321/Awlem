package com.semi.splash.register

import com.semi.entity.response.splash.LoginResponse
import com.semi.network.EndPoint.registerConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RegisterService {

    @FormUrlEncoded
    @POST(registerConstant)
    fun registerAsync(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("phone") phone: String,
        @Field("password") password: String,
        @Field("device_token") device_token: String
    ): Deferred<LoginResponse>


}