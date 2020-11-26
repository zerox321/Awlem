package com.semi.entity.response.home

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class CategoryResponse(
    @Json(name = "id") val id: Int,
    @Json(name = "name") val name: String?,
    @Json(name = "photo") val photo: String?
)