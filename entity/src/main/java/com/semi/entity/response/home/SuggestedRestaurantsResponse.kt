package com.semi.entity.response.home

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class SuggestedRestaurantsResponse(
    @Json(name = "featured_meals") val featuredMeals: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "photo") val photo: String?
)