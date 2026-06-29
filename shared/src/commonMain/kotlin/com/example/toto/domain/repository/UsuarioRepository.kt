package com.example.toto.domain.repository

import com.example.toto.domain.model.Usuario

interface UsuarioRepository {
    suspend fun iniciarSesion(email: String, contrasena: String): Usuario?
    suspend fun registrarUsuario(usuario: Usuario, contrasena: String): Boolean
    suspend fun obtenerPerfilActual(): Usuario?
    suspend fun cerrarSesion()
}