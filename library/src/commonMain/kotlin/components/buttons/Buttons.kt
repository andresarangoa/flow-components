package io.github.kotlin.components.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import components.AppColorScheme
import components.foundations.RobotoTypography
import components.progressIndicator.ZoomIcon
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun RoundedCornerOutlinedButton(
    text: String,
    modifier: Modifier= Modifier.fillMaxWidth(),
    customColors:ProvidableCompositionLocal<AppColorScheme>? =null,
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        containerColor = Color.White,
        contentColor = Color.Black,
        disabledContentColor = Color.Gray
    ),
    borderStroke: BorderStroke = BorderStroke(
        width = 1.dp,
        color = customColors?.current?.surfacePrimaryButton?:Color.Gray
    ),
    cornerRadius: Dp = 16.dp,
    enabled: Boolean = true,
    buttonIcon: DrawableResource? = null,
    onClick: () -> Unit,
) {
    OutlinedButton(
        modifier = modifier,
        colors = colors,
        border = borderStroke,
        enabled = enabled,
        shape = RoundedCornerShape(cornerRadius),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (null != buttonIcon) {
                Image(
                    modifier = Modifier
                        .size(24.dp, 24.dp),
                    painter = painterResource(buttonIcon),
                    contentDescription =""
                )
            }
            Box(
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = text,
                    modifier = Modifier.padding(12.dp),
                    textAlign = TextAlign.Center,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}
@Composable
fun GradientButton(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    brush: Brush = Brush.horizontalGradient(
        colors = listOf(Color(0xFF6A11CB), Color(0xFF2575FC)) // default gradient
    ),
    cornerRadius: Dp = 16.dp,
    contentColor: Color = Color.White,
    isLoading: Boolean = false,
    height: Dp = 55.dp,
    enabled: Boolean = true,
    delay: Long = 500,
    onClick: () -> Unit,
) {
    var isClickable by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(cornerRadius))
            .height(height)
            .background(brush)
            .clickable(enabled = enabled && isClickable) {
                isClickable = false
                onClick()
                scope.launch {
                    delay(delay)
                    isClickable = true
                }
            },
        contentAlignment = Alignment.Center
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.size(24.dp),
                color = contentColor,
                strokeWidth = 2.dp
            )
        } else {
            Text(
                text = text,
                color = contentColor,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}



@Composable
fun RoundedCornerFilledButton(
    text: String,
    modifier: Modifier = Modifier.fillMaxWidth(),
    customColors:ProvidableCompositionLocal<AppColorScheme>? =null,
    colors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = customColors?.current?.surfacePrimaryButton?:Color.Gray,
        contentColor = Color.White,
        disabledContainerColor = Color.Gray,
        disabledContentColor = Color.Black
    ),
    textStyle: TextStyle = RobotoTypography().bodyMedium.copy(
        color = customColors?.current?.textPrimaryButton?:Color.White,
        fontWeight = FontWeight.Bold
    ),
    cornerRadius: Dp = 16.dp,
    enabled: Boolean = true,
    isLoading: Boolean = false,
    delay: Long = 0,
    onClick: () -> Unit,
)
 {
    var isClickable by remember { mutableStateOf(true) }
    val scope = rememberCoroutineScope()
    Button(
        modifier = modifier,
        colors = colors,
        enabled = enabled,
        shape = RoundedCornerShape(cornerRadius),
        onClick = {
            if (isClickable) {
                isClickable = false
                onClick()
                scope.launch {
                    delay(delay)
                    isClickable = true
                }
            }
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (isLoading) {
                ZoomIcon()
            } else {
                Text(
                    style = textStyle,
                    text = text,
                    modifier = Modifier.padding(12.dp),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}