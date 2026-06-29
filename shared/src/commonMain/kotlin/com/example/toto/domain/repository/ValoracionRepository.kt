package com.example.toto.domain.repository

import com.example.toto.domain.model.Valoracion

interface ValoracionRepository {
    suspend fun obtenerValoracionesDeObra(obraId: Int): List<Valoracion>
    suspend fun guardarValoracion(valoracion: Valoracion): Boolean
    suspend fun eliminarValoracion(id: Int): Boolean
}