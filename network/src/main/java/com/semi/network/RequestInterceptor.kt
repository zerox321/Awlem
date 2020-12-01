package com.semi.network

import com.semi.entity.sharedPref.Pref
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class RequestInterceptor @Inject constructor(private val pref: Pref) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val authorization = pref.credentials()
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url
        val url = originalUrl.newBuilder().build()
        val requestBuilder = originalRequest.newBuilder().url(url).apply {
            addHeader("Accept", "application/json")
            addHeader("Content-Type", "application/json")
        }
        if (authorization != null) {
            requestBuilder.addHeader("Authorization", authorization)
        }

        val request = requestBuilder.build()
        val response = chain.proceed(request)
        response.code//status code
        return response
    }
}
