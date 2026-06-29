package com.example.toto.domain.repository

import com.example.toto.domain.model.MediaList

interface MediaListRepository {
    // Watchlist (CU03)
    suspend fun obtenerWatchlist(usuarioId: Int): MediaList?
    suspend fun agregarAWatchlist(usuarioId: Int, obraId: Int): Boolean
    suspend fun quitarDeWatchlist(usuarioId: Int, obraId: Int): Boolean

    // Listas Personalizadas (CU04)
    suspend fun obtenerListasDeUsuario(usuarioId: Int): List<MediaList>
    suspend fun crearLista(lista: MediaList): Boolean
    suspend fun actualizarLista(lista: MediaList): Boolean
    suspend fun eliminarLista(id: Int): Boolean
}