package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UsuarioApi {
    @POST("auth/login")
    suspend fun login(@Body user: Usuario): Response<Usuario>

    @POST("auth/registro")
    suspend fun register(@Body user: Usuario): Response<Usuario>

    @GET("usuarios/{id}")
    suspend fun getUserById(@Path("id") id: Long): Response<Usuario>

    @PUT("usuarios/{id}")
    suspend fun updateUser(
        @Path("id") id: Long,
        @Body usuario: Usuario
    ): Response<Usuario>
}
