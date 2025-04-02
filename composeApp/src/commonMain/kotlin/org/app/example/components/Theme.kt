package org.app.example.components

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

/**
 * FlowColors - Defines the color palette for Flow Components
 */
data class FlowColors(
    // Primary colors
    val primary: Color,
    val primaryVariant: Color,
    val secondary: Color,
    val secondaryVariant: Color,

    // Background colors
    val background: Color,
    val surface: Color,
    val surfaceVariant: Color,

    // Special component colors
    val surfaceOptionalNavbar: Color,
    val surfaceOnTabBarBottom: Color,

    // Text colors
    val textPrimary: Color,
    val textSecondary: Color,
    val textTertiary: Color,
    val textBottomBanner: Color,
    val textQuaternaryButton: Color,

    // Button colors
    val buttonPrimary: Color,
    val buttonSecondary: Color,
    val buttonTertiary: Color,
    val buttonDisabled: Color,

    // Input fields
    val inputBackground: Color,
    val inputBorder: Color,
    val inputText: Color,
    val inputHint: Color,
    val inputError: Color,

    // Status colors
    val success: Color,
    val warning: Color,
    val error: Color,
    val info: Color
)

/**
 * Default light color palette
 */
val LightFlowColors = FlowColors(
    primary = Color(0xFF6200EE),
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6),
    secondaryVariant = Color(0xFF018786),

    background = Color(0xFFF5F5F5),
    surface = Color(0xFFFFFFFF),
    surfaceVariant = Color(0xFFE0E0E0),

    surfaceOptionalNavbar = Color(0xFF1F1F1F),
    surfaceOnTabBarBottom = Color(0xFF3700B3),

    textPrimary = Color(0xFF000000),
    textSecondary = Color(0xFF757575),
    textTertiary = Color(0xFFAAAAAA),
    textBottomBanner = Color(0xFFFFFFFF),
    textQuaternaryButton = Color(0xFF6200EE),

    buttonPrimary = Color(0xFF6200EE),
    buttonSecondary = Color(0xFF03DAC6),
    buttonTertiary = Color(0xFF757575),
    buttonDisabled = Color(0xFFCCCCCC),

    inputBackground = Color(0xFFF5F5F5),
    inputBorder = Color(0xFFE0E0E0),
    inputText = Color(0xFF000000),
    inputHint = Color(0xFF757575),
    inputError = Color(0xFFB00020),

    success = Color(0xFF4CAF50),
    warning = Color(0xFFFFA000),
    error = Color(0xFFB00020),
    info = Color(0xFF2196F3)
)

/**
 * Default dark color palette
 */
val DarkFlowColors = FlowColors(
    primary = Color(0xFFBB86FC),
    primaryVariant = Color(0xFF3700B3),
    secondary = Color(0xFF03DAC6),
    secondaryVariant = Color(0xFF018786),

    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E),
    surfaceVariant = Color(0xFF2D2D2D),

    surfaceOptionalNavbar = Color(0xFF1F1F1F),
    surfaceOnTabBarBottom = Color(0xFF3700B3),

    textPrimary = Color(0xFFFFFFFF),
    textSecondary = Color(0xFFB3B3B3),
    textTertiary = Color(0xFF757575),
    textBottomBanner = Color(0xFFFFFFFF),
    textQuaternaryButton = Color(0xFFBB86FC),

    buttonPrimary = Color(0xFFBB86FC),
    buttonSecondary = Color(0xFF03DAC6),
    buttonTertiary = Color(0xFF757575),
    buttonDisabled = Color(0xFF424242),

    inputBackground = Color(0xFF2D2D2D),
    inputBorder = Color(0xFF424242),
    inputText = Color(0xFFFFFFFF),
    inputHint = Color(0xFFB3B3B3),
    inputError = Color(0xFFCF6679),

    success = Color(0xFF4CAF50),
    warning = Color(0xFFFFA000),
    error = Color(0xFFCF6679),
    info = Color(0xFF2196F3)
)

/**
 * CompositionLocal to provide FlowColors through the composition tree
 */
val LocalCustomColorsPalette = staticCompositionLocalOf<FlowColors> {
    error("No FlowColors provided")
}

/**
 * FlowTheme - The main theme composable for Flow Components
 *
 * @param darkTheme Whether to use the dark theme
 * @param flowColors Custom colors to use, defaults to automatic based on darkTheme
 * @param content Content to be styled by this theme
 */
@Composable
fun FlowTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    flowColors: FlowColors = if (darkTheme) DarkFlowColors else LightFlowColors,
    content: @Composable () -> Unit
) {
    // Create Material3 color schemes from our custom colors
    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = flowColors.primary,
            secondary = flowColors.secondary,
            background = flowColors.background,
            surface = flowColors.surface,
            error = flowColors.error
        )
    } else {
        lightColorScheme(
            primary = flowColors.primary,
            secondary = flowColors.secondary,
            background = flowColors.background,
            surface = flowColors.surface,
            error = flowColors.error
        )
    }

    // Provide our custom colors through composition
    CompositionLocalProvider(
        LocalCustomColorsPalette provides flowColors
    ) {
        // Use Material3 theme as the base
        MaterialTheme(
            colorScheme = colorScheme,
            content = content
        )
    }
}