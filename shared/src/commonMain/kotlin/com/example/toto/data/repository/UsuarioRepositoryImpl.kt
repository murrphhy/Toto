package com.example.toto.data.repository

import com.example.toto.domain.model.Usuario
import com.example.toto.domain.repository.UsuarioRepository

class UsuarioRepositoryImpl : UsuarioRepository {
    override suspend fun iniciarSesion(email: String, contrasena: String): Usuario? {
        // Aquí irá la llamada a tu servidor Ktor en el futuro
        return null
    }

    override suspend fun registrarUsuario(usuario: Usuario, contrasena: String): Boolean {
        // Lógica de registro
        return true
    }

    override suspend fun obtenerPerfilActual(): Usuario? = null

    override suspend fun cerrarSesion() {
        // Borrar tokens o sesión local
    }
}