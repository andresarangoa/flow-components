package org.app.example.navigation

sealed interface ScreenStartEvent {
    data object ClickButton: ScreenStartEvent
    data class UpdateText(val text: String): ScreenStartEvent
}