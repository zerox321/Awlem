package com.semi.entity.response.menu

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class FaqResponse(
    @Json(name = "active") val active: Int?,
    @Json(name = "answer") val answer: String?,
    @Json(name = "created_at") val createdAt: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "question") val question: String?,
    @Json(name = "updated_at") val updatedAt: String?
)