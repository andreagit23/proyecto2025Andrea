// src/main/java/com/andrea_murillo/involucrate/network/PedidoApi.kt
package com.andrea_murillo.involucrate.network

import com.andrea_murillo.involucrate.model.Pedido
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PedidoApi {
    @GET("pedidos/usuario/{id}")
    suspend fun listarPedidosUsuario(@Path("id") usuarioId: Long): Response<List<Pedido>>

    @GET("pedidos/{id}")
    suspend fun obtenerPedidoPorId(@Path("id") id: Long): Response<Pedido>
}