package com.semi.entity.response.splash

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class ResendCodeResponse(
    @Json(name = "success") val success: Boolean?
)