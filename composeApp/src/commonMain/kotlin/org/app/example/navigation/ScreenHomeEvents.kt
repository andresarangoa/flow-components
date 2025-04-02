package org.app.example.navigation

sealed interface ScreenHomeEvents {
    data object ClickButtonLogout: ScreenHomeEvents
}