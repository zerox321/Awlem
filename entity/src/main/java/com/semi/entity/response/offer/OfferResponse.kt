package com.semi.entity.response.offer

import androidx.annotation.Keep

import com.squareup.moshi.Json


@Keep
data class OfferResponse(
    @Json(name = "data") val `data`: List<OfferResponseData>?,
)

@Keep
data class OfferResponseData(
    @Json(name = "branch") val branch: List<OfferResponseBranch>?,
    @Json(name = "branches_count") val branchesCount: Int?,
    @Json(name = "category_id") val categoryId: Int?,
    @Json(name = "featured") val featured: Int?,
    @Json(name = "featured_meals") val featuredMeals: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "photo") val photo: String?,
    @Json(name = "rate") val rate: Float?
)

@Keep
data class OfferResponseBranch(
    @Json(name = "area_id") val areaId: Int?,
    @Json(name = "branch_photo") val branchPhoto: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "location_lat") val locationLat: Double?,
    @Json(name = "location_lon") val locationLon: Double?,
    @Json(name = "location_name") val locationName: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "open_close") val openClose: Boolean?,
    @Json(name = "open_dayes") val openDayes: String?,
    @Json(name = "open_from") val openFrom: String?,
    @Json(name = "open_to") val openTo: String?,
    @Json(name = "restorant_id") val restorantId: Int?
)