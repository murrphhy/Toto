package com.example.toto.domain.model
import kotlinx.serialization.Serializable

@Serializable
data class Platform(
    val id: Int,
    val nombre: String,
    val precio: Double? = null
)