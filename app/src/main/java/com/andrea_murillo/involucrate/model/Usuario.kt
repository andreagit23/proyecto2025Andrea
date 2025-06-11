package com.andrea_murillo.involucrate.model

data class Usuario(
    val id: Long? = null,
    val nombre: String,
    val apellidos: String,
    val dni: String,
    val correoElectronico: String,
    val hashContrasena: String,
    val tipo: String,
    val telefono: String,
    val estadoCuenta: String = "activo"
)
