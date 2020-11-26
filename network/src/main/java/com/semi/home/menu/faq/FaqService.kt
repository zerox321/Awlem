package com.semi.home.menu.faq

import com.semi.entity.response.menu.FaqResponse
import com.semi.network.EndPoint.faqConstant
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface FaqService {

    @GET(faqConstant)
    fun getFaqAsync(
    ): Deferred<List<FaqResponse>>

}