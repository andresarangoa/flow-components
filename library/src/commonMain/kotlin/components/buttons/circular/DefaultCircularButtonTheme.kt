package components.buttons.circular

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.icon_cancel
import org.jetbrains.compose.resources.DrawableResource

data class DefaultCircularButtonTheme(
    var modifier: Modifier = Modifier,
    var iconModifier: Modifier = Modifier,
    var iconColor: Color = Color.White,
    var borderColor: Color = Color.White,
    var backgroundColor: Color = Color.Black,
    var icon: DrawableResource = Res.drawable.icon_cancel,
    var titleButtonStyle: TextStyle,
)

@Composable
fun defaultCircularButtonTheme(
    icon: DrawableResource = Res.drawable.icon_cancel,
    backgroundColor: Color = Color.Black,
    iconColor: Color = Color.White,
    iconModifier: Modifier = Modifier,
    titleButtonStyle: TextStyle = TextStyle()
    ) = DefaultCircularButtonTheme(
    icon = icon,
    backgroundColor = backgroundColor,
    iconColor = iconColor,
    iconModifier = iconModifier,
    titleButtonStyle = titleButtonStyle
)

@Composable
fun defaultCircularWithBorderButtonTheme(
    icon: DrawableResource =  Res.drawable.icon_cancel,
    backgroundColor: Color = Color.Black,
    borderColor: Color = Color.White,
    iconColor: Color = Color.White,
    iconModifier: Modifier = Modifier,
    titleButtonStyle: TextStyle = TextStyle()
) = DefaultCircularButtonTheme(
    modifier = Modifier.border(1.dp, borderColor, CircleShape),
    icon = icon,
    backgroundColor = backgroundColor,
    iconColor = iconColor,
    iconModifier = iconModifier,
    titleButtonStyle = titleButtonStyle
)