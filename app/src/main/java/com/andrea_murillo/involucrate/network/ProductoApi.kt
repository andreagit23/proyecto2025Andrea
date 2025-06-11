package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.Producto
import com.andrea_murillo.involucrate.model.ProductoRequest
import retrofit2.Response
import retrofit2.http.*

interface ProductoApi {

    @GET("productos")
    suspend fun listarProductosDisponibles(): Response<List<Producto>>

    @GET("productos/{id}")
    suspend fun obtenerProductoPorId(@Path("id") id: Long): Response<Producto>

    @GET("productos/usuario/{id}")
    suspend fun getProductosDelUsuario(@Path("id") userId: Long): Response<List<Producto>>

    @POST("productos")
    suspend fun crearProducto(@Body request: ProductoRequest): Response<Producto>

    @PUT("productos/{id}")
    suspend fun actualizarProducto(
        @Path("id") id: Long,
        @Body request: ProductoRequest
    ): Response<Producto>

    @DELETE("productos/{id}")
    suspend fun eliminarProducto(@Path("id") id: Long): Response<Unit>
}
