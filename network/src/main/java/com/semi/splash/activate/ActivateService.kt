package com.semi.splash.activate

import com.semi.entity.response.splash.LoginResponse
import com.semi.entity.response.splash.ResendCodeResponse
import com.semi.network.EndPoint.activeAccountConstant
import com.semi.network.EndPoint.reSendCodeConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.*

interface ActivateService {

    @FormUrlEncoded
    @POST(activeAccountConstant)
    fun activeAccountAsync(
        @Header("Authorization") Authorization: String,
        @Field("virification_code") virification_code: String
    ): Deferred<LoginResponse>


    @GET(reSendCodeConstant)
    fun reSendCodeAsync(
        @Header("Authorization") Authorization: String
    ): Deferred<ResendCodeResponse>


}