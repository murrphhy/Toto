package com.example.toto.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Obra(
    val id: Int,
    val nombre: String,
    val descripcion_corta: String,
    val descripcion_larga: String,
    val fecha: String,
    val director: String,
    val posterUrl: String? = null
)