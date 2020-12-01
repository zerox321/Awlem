package com.semi.entity.response.splash

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class RegisterResponse(
    @Json(name = "data") val `data`: RegisterResponseData?,
    @Json(name = "success") val success: Boolean?
)

@Keep
data class RegisterResponseData(
    @Json(name = "token") val token: String?,
    @Json(name = "virification_code") val virificationCode: Int?
)