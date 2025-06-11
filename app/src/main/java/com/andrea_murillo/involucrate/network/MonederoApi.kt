package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.Monedero
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MonederoApi {
    @GET("monederos/{usuarioId}")
    suspend fun obtenerMonedero(
        @Path("usuarioId") usuarioId: Long
    ): Response<Monedero>
}