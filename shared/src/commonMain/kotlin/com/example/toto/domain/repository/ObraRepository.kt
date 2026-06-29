package com.example.toto.domain.repository

import com.example.toto.domain.model.Obra

interface ObraRepository {
    suspend fun buscarObras(busqueda: String): List<Obra>
    suspend fun obtenerDetalleObra(id: Int): Obra?
    suspend fun obtenerTendencias(): List<Obra>
}