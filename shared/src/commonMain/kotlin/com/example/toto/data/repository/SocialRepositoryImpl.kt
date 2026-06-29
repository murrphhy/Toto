package com.example.toto.data.repository

import com.example.toto.domain.model.Usuario
import com.example.toto.domain.repository.SocialRepository

class SocialRepositoryImpl : SocialRepository {
    override suspend fun seguirUsuario(seguidorId: Int, seguidoId: Int): Boolean = true
    override suspend fun dejarDeSeguirUsuario(seguidorId: Int, seguidoId: Int): Boolean = true
    override suspend fun obtenerSeguidores(usuarioId: Int): List<Usuario> = emptyList()
    override suspend fun obtenerSeguidos(usuarioId: Int): List<Usuario> = emptyList()
    override suspend fun darMeGustaAReseña(usuarioId: Int, valoracionId: Int): Boolean = true
}