package com.example.toto.domain.model
import kotlinx.serialization.Serializable

@Serializable
data class Actor(
    val id: Int,
    val nombre: String,
    val descripcion: String,
    val edad: Int
)