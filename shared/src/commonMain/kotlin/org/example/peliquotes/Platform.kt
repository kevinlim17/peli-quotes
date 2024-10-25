package org.example.peliquotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform