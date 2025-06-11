package com.andrea_murillo.involucrate.model

import java.math.BigDecimal

data class Pedido(
    val id: Long?,
    val producto: Producto,
    val comprador: Usuario,
    val ong: Ong,
    val precioTotal: BigDecimal,
    val cantidadDonada: BigDecimal,
    val cantidadVendedor: BigDecimal,
    val estado: EstadoPedido,
    val creadoEn: String
)
