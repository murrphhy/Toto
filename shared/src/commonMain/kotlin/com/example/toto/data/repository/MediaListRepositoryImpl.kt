package com.example.toto.data.repository

import com.example.toto.domain.model.MediaList
import com.example.toto.domain.repository.MediaListRepository

class MediaListRepositoryImpl : MediaListRepository {
    override suspend fun obtenerWatchlist(usuarioId: Int): MediaList? = null
    override suspend fun agregarAWatchlist(usuarioId: Int, obraId: Int): Boolean = true
    override suspend fun quitarDeWatchlist(usuarioId: Int, obraId: Int): Boolean = true
    override suspend fun obtenerListasDeUsuario(usuarioId: Int): List<MediaList> = emptyList()
    override suspend fun crearLista(lista: MediaList): Boolean = true
    override suspend fun actualizarLista(lista: MediaList): Boolean = true
    override suspend fun eliminarLista(id: Int): Boolean = true
}