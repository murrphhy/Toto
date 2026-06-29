package com.example.toto.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Usuario(
    val id: Int,
    val nombre: String,
    val email: String,
    val telefono: String? = null,
    val rol: String = "USER"
)