package com.example.toto.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val releaseDate: String,
    val director: String,
    val posterUrl: String? = null
)