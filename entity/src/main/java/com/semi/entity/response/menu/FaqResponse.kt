package com.semi.entity.response.menu

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class FaqResponse(
    @Json(name = "answer") val answer: String?,
    @Json(name = "id") val id: Int,
    @Json(name = "question") val question: String?
)