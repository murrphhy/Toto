package com.example.toto.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Valoracion(
    val id: Int,
    val userId: Int,
    val movieId: Int,
    val puntuacion: Double,
    val comentario: String,
    val createdAt: String? = null
)