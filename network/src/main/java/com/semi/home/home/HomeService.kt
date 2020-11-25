package com.semi.home.home

import com.semi.entity.response.home.CategoryResponse
import com.semi.entity.response.home.SuggestedProducts
import com.semi.entity.response.home.SuggestedRestaurantsResponse
import com.semi.network.EndPoint
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface HomeService {

    @GET(EndPoint.getTypesConstant)
    fun getTypesAsync(
    ): Deferred<List<CategoryResponse>>

    @GET(EndPoint.sugestedRestorantsConstant)
    fun suggestedRestaurantsAsync(
    ): Deferred<List<SuggestedRestaurantsResponse>>


    @GET(EndPoint.sugestedProductsConstant)
    fun suggestedProductsAsync(
    ): Deferred<List<SuggestedProducts>>


}