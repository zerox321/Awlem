package com.semi.entity.response.home

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class SuggestedProducts(
    @Json(name = "description") val description: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "photo") val photo: String?,
    @Json(name = "ready_in") val readyIn: Int?,
    @Json(name = "ready_to") val readyTo: Int?,
    @Json(name = "restorant") val restorant: SuggestedProductsRestorant?,
    @Json(name = "restorant_id") val restorantId: Int?
)

@Keep
data class SuggestedProductsRestorant(
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "photo") val photo: String?
)