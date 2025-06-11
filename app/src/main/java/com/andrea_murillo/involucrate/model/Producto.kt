package com.andrea_murillo.involucrate.model

import java.math.BigDecimal

data class Producto(
    val id: Long?,
    val nombre: String,
    val descripcion: String,
    val precio: BigDecimal,
    val porcentajeDonacion: Int,
    val imagen: String?,
    val estado: String,
    val vendedor: Usuario,
    val categoria: Categoria
)