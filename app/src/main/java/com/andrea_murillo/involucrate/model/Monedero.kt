package com.andrea_murillo.involucrate.model

import java.math.BigDecimal

data class Monedero(
    val id: Long,
    val usuario: Long,
    val cantidad: BigDecimal
)