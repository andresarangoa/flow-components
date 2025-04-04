package io.github.kotlin.fibonacci.components.addAnotherItemButton

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import components.AppColorScheme

/**
 * A class containing all style parameters for the AddAnotherItemButton.
 * This allows for easy theming and customization of the button's appearance.
 */
data class AddAnotherItemButtonStyle(
    // Layout dimensions
    val padding: PaddingValues = PaddingValues(0.dp),
    val height: Dp = 56.dp,
    val iconSize: Dp = 16.dp,
    val spacerWidth: Dp = 8.dp,

    // Border properties
    val borderWidth: Dp = 1.dp,
    val borderColor: Color = Color(0xFFCBD2E0),
    val shape: Shape = RoundedCornerShape(8.dp),
    val dashWidth: Dp = 4.dp,
    val dashGap: Dp = 4.dp,

    // Colors
    val backgroundColor: Color = Color(0xFFF6F7F9),
    val contentColor: Color = Color(0xFF6F7A8B),

    // Default elevation (set to 0 for flat appearance)
    val defaultElevation: Dp = 0.dp,
    val pressedElevation: Dp = 0.dp
) {
    companion object {
        /**
         * Default style matching the original implementation
         */
        @Composable
        fun defaultTheme(
            customColorScheme: ProvidableCompositionLocal<AppColorScheme>? = null,
        ): AddAnotherItemButtonStyle =
            AddAnotherItemButtonStyle(
                borderColor = customColorScheme?.current?.borderBold ?: Color.Unspecified,
                backgroundColor = customColorScheme?.current?.surfaceSecondary
                    ?: Color.Unspecified,
            )


        val Default = AddAnotherItemButtonStyle()

        /**
         * A variant with more pronounced dashes
         */
        val WideDashed = AddAnotherItemButtonStyle(
            dashWidth = 8.dp,
            dashGap = 4.dp
        )

        /**
         * A higher contrast variant
         */
        val HighContrast = AddAnotherItemButtonStyle(
            backgroundColor = Color.White,
            contentColor = Color(0xFF2C3E50),
            borderColor = Color(0xFF95A5A6)
        )
    }
}