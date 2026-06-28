package com.example.toto.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Review(
    val id: Int,
    val userId: Int,
    val movieId: Int,
    val rating: Double, // Puntuación (ej. 4.5 estrellas)
    val comment: String,
    val createdAt: String? = null
)