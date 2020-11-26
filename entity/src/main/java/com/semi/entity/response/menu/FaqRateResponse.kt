package com.semi.entity.response.menu

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class FaqRateResponse(
    @Json(name = "success") val success: Boolean?
)