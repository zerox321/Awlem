package com.semi.home.offer

import com.semi.entity.response.offer.OfferResponse
import com.semi.network.EndPoint
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface OfferService {

    @GET(EndPoint.restorantsHasOffersConstant)
    fun restorantsHasOffersAsync(
        @Query("page") page: String
    ): Deferred<OfferResponse>


}