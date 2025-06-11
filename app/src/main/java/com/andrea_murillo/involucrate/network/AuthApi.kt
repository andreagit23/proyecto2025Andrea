package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.AuthRequest
import com.andrea_murillo.involucrate.model.AuthResponse
import com.andrea_murillo.involucrate.model.Ong
import com.andrea_murillo.involucrate.model.Usuario
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("auth/login")
    suspend fun login(@Body request: AuthRequest): Response<AuthResponse>

    @POST("auth/registro")
    suspend fun register(@Body usuario: Usuario): Response<Usuario>

    @POST("ongs")
    suspend fun registerOng(@Body ong: Ong): Response<Ong>
}