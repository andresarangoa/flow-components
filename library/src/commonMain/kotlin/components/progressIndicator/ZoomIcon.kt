package components.progressIndicator

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.icon_settings
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

/**
 * A pulsating icon that zooms in and out continuously.
 *
 * @param icon The drawable resource to display. Defaults to settings icon.
 * @param initialScale The starting scale of the icon (0.0f to 1.0f).
 * @param targetScale The maximum scale the icon will reach.
 * @param durationMillis The duration of one complete animation cycle in milliseconds.
 * @param iconSize The size of the icon in dp.
 */
@Composable
fun ZoomIcon(
    icon: DrawableResource = Res.drawable.icon_settings,
    initialScale: Float = 0.4f,
    targetScale: Float = 1f,
    animDuration: Int = 1000,
    iconSize: Int = 46
) {
    // Infinite transition for continuous animation
    val infiniteTransition = rememberInfiniteTransition()

    // Animate the scale value
    val scale by infiniteTransition.animateFloat(
        initialValue = initialScale,
        targetValue = targetScale,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                // Use the parameter variable name that's different from the keyframes property
                durationMillis = animDuration
                (initialScale + (targetScale - initialScale) * 0.3f) at (animDuration * 0.3).toInt()
                (initialScale + (targetScale - initialScale) * 0.7f) at (animDuration * 0.6).toInt()
                targetScale at (animDuration * 0.9).toInt()
            },
            repeatMode = RepeatMode.Reverse
        )
    )

    // Icon with zoom animation
    Icon(
        painter = painterResource(icon),
        contentDescription = null,
        modifier = Modifier
            .scale(scale)
            .size(iconSize.dp)
    )
}


// Example usage of the custom keyframes variant:
/*
ZoomIconWithCustomKeyframes(
    icon = Res.drawable.my_icon,
    iconSize = 52
) {
    animateFloat(
        initialValue = 0.5f,
        targetValue = 1.2f,
        animationSpec = infiniteRepeatable(
            animation = tween(800, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )
}
*/