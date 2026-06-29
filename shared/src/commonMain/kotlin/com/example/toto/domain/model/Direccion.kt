package com.example.toto.domain.model
import kotlinx.serialization.Serializable

class Direccion {
    @Serializable
    data class Direccion(
        val calle: String,
        val numero: Int,
        val ciudad: String,
        val provincia: String
    )
}
