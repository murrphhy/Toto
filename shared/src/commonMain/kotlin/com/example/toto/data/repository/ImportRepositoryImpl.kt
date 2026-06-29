package com.example.toto.data.repository

import com.example.toto.domain.repository.ImportRepository

class ImportRepositoryImpl : ImportRepository {
    override suspend fun importarDesdeLetterboxd(usuarioId: Int, csvContent: String): Boolean {
        // Aquí irá la lógica pesada de parsear el CSV y buscar IDs de TMDB
        return true
    }
}