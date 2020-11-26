package com.semi.entity.response.menu

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class StaticPageResponse(
    @Json(name = "body") val body: String?,
    @Json(name = "created_at") val createdAt: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "title") val title: String?,
    @Json(name = "updated_at") val updatedAt: String?,
    @Json(name = "web") val web: Int?
)