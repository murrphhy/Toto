package com.example.toto.data.repository

import com.example.toto.domain.model.Obra
import com.example.toto.domain.repository.ObraRepository

class ObraRepositoryImpl : ObraRepository {
    override suspend fun buscarObras(busqueda: String): List<Obra> = emptyList()
    override suspend fun obtenerDetalleObra(id: Int): Obra? = null
    override suspend fun obtenerTendencias(): List<Obra> = emptyList()
}