package com.example.toto.domain.repository

interface ImportRepository {
    // Procesa el contenido del CSV y vincula las obras al historial del usuario
    suspend fun importarDesdeLetterboxd(usuarioId: Int, csvContent: String): Boolean
}