package com.andrea_murillo.involucrate.model

data class Ong(
    val id: Long? = null,
    val usuario: Usuario,
    val nombreOng: String,
    val descripcion: String,
    val direccion: String,
    val telefono: String,
    val imagen: String? = null,
    val correoElectronico: String,
    val url: String? = null,
    val verificada: Boolean = false
)