package com.andrea_murillo.involucrate.model

import java.math.BigDecimal

// ProductoRequest.kt
data class ProductoRequest(
    val nombre: String,
    val descripcion: String,
    val precio: BigDecimal,
    val porcentajeDonacion: Int,
    val imagen: String,
    val estado: String,
    val vendedorId: Long,
    val categoriaId: Long
)

