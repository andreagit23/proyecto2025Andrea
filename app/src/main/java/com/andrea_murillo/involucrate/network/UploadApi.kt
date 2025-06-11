// src/main/java/com/andrea_murillo/involucrate/network/UploadApi.kt
package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.UploadResponse
import okhttp3.MultipartBody
import retrofit2.Response
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface UploadApi {
    @Multipart
    @POST("uploads/imagen")
    suspend fun subirImagen(
        @Part file: MultipartBody.Part
    ): Response<UploadResponse>
}
