package com.semi.entity.response.splash

import androidx.annotation.Keep
import com.squareup.moshi.Json

@Keep
data class LoginResponse(
    @Json(name = "data") val `data`: LoginResponseData?,
    @Json(name = "success") val success: Boolean?
)


@Keep
data class LoginResponseData(
    @Json(name = "address") val address: String?,
    @Json(name = "device_token") val deviceToken: String?,
    @Json(name = "email") val email: String?,
    @Json(name = "id") val id: Int?,
    @Json(name = "name") val name: String?,
    @Json(name = "phone") val phone: String?,
    @Json(name = "photo") val photo: String?,
    @Json(name = "token") val token: String?,
    @Json(name = "active") val active: Int?,
    @Json(name = "error") val error: String?,
    @Json(name = "virification_code") val virificationCode: Int?
)