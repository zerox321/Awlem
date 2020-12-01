package com.semi.home.menu.profile

import com.semi.entity.response.splash.LoginResponse
import com.semi.network.EndPoint.updateUserPhotoConstant
import kotlinx.coroutines.Deferred
import okhttp3.MultipartBody
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ProfileService {


    @Multipart
    @POST(updateUserPhotoConstant)
    fun updateUserPhotoAsync(
//        @Part("type_id") type_id: RequestBody,
        @Part photo: MultipartBody.Part
    ): Deferred<LoginResponse>


}