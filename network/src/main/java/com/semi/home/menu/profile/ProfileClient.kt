package com.semi.home.menu.profile

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File


class ProfileClient(private val service: ProfileService) {


    suspend fun updateUserPhotoTask(photoFile: File) = withContext(Dispatchers.IO) {
        val requestBody = photoFile.asRequestBody("image/*".toMediaTypeOrNull())
        val insurancePhotoFileUpload =
            MultipartBody.Part.createFormData("photo", photoFile.name, requestBody)
        service.updateUserPhotoAsync(photo = insurancePhotoFileUpload).await()
    }
}
