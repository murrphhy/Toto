package com.example.toto

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform