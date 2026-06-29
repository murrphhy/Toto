package com.example.toto.domain.repository

import com.example.toto.domain.model.Usuario

interface SocialRepository {
    suspend fun seguirUsuario(seguidorId: Int, seguidoId: Int): Boolean
    suspend fun dejarDeSeguirUsuario(seguidorId: Int, seguidoId: Int): Boolean
    suspend fun obtenerSeguidores(usuarioId: Int): List<Usuario>
    suspend fun obtenerSeguidos(usuarioId: Int): List<Usuario>
    suspend fun darMeGustaAReseña(usuarioId: Int, valoracionId: Int): Boolean
}