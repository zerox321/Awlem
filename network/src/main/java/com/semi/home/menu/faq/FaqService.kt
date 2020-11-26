package com.semi.home.menu.faq

import com.semi.entity.response.menu.FaqRateResponse
import com.semi.entity.response.menu.FaqResponse
import com.semi.network.EndPoint.faqConstant
import com.semi.network.EndPoint.insertComplaintConstant
import com.semi.network.EndPoint.rateFqaConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FaqService {

    @GET(faqConstant)
    fun getFaqAsync(
    ): Deferred<List<FaqResponse>>

    @FormUrlEncoded
    @POST(rateFqaConstant)
    fun rateFqaAsync(
        @Field("faq_id") faq_id: String,
        @Field("helpfull") helpfull: String,
    ): Deferred<FaqRateResponse>

    @FormUrlEncoded
    @POST(insertComplaintConstant)
    fun insertComplaintAsync(
        @Field("name") name: String,
        @Field("body") body: String,
    ): Deferred<FaqRateResponse>

}