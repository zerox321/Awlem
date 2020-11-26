package com.semi.home.menu.staticPage

import com.semi.entity.response.menu.StaticPageResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface StaticPageService {

    @GET("page/1/1")
    fun getPageAsync(
    ): Deferred<StaticPageResponse>


}