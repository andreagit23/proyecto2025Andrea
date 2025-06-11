package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.Ong
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface OngApi {
    @GET("ongs")
    suspend fun obtenerOngs(): Response<List<Ong>>

    @PUT("ongs/{id}")
    suspend fun actualizarOng(
        @Path("id") id: Long,
        @Body ong: Ong
    ): Response<Ong>
}