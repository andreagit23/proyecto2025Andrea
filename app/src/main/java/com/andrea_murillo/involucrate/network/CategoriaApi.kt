package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.Categoria
import retrofit2.Response
import retrofit2.http.GET

interface CategoriaApi {
    @GET("categorias")
    suspend fun obtenerCategorias(): Response<List<Categoria>>
}
