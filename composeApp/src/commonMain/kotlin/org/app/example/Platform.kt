package org.app.example

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform