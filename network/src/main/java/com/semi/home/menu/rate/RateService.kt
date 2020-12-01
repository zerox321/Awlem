package com.semi.home.menu.rate

import com.semi.entity.response.splash.ResendCodeResponse
import com.semi.network.EndPoint.ratingAppConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RateService {

    @FormUrlEncoded
    @POST(ratingAppConstant)
    fun ratingApAsync(
        @Field("rate") rate: String,
        @Field("review") review: String
    ): Deferred<ResendCodeResponse>


}