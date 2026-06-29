package com.example.toto.data.repository

import com.example.toto.domain.model.Valoracion
import com.example.toto.domain.repository.ValoracionRepository

class ValoracionRepositoryImpl : ValoracionRepository {
    override suspend fun obtenerValoracionesDeObra(obraId: Int): List<Valoracion> = emptyList()
    override suspend fun guardarValoracion(valoracion: Valoracion): Boolean = true
    override suspend fun eliminarValoracion(id: Int): Boolean = true
}