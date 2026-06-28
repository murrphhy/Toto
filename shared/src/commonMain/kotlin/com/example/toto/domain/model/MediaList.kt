package com.example.toto.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class MediaList(
    val id: Int,
    val title: String,
    val description: String? = null,
    val userId: Int,
    val isWatchlist: Boolean = false,
    val movieIds: List<Int> = emptyList() // IDs de las películas que contiene
)