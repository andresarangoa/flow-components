package components.dividers

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import components.foundations.RobotoTypography

@Composable
fun TextInMiddleDivider
            (text: String,
             modifier: Modifier = Modifier,
             textStyle: TextStyle = RobotoTypography().bodyLarge
             ) {
    Box(modifier = modifier.fillMaxWidth()) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            HorizontalDivider(
                modifier = Modifier.weight(0.45f),
                color = Color.Gray
            )
            Text(
                modifier = Modifier.weight(0.1f),
                text = text,
                style =textStyle,
                textAlign = TextAlign.Center,
            )
            HorizontalDivider(
                modifier = Modifier.weight(0.45f),
                color = Color.Gray//MaterialTheme.colorScheme.tertiary
            )
        }
    }
}

@Composable
fun HorizontalDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = 1.dp,
    color: Color = Color.Black,
) = Canvas(modifier.fillMaxWidth().height(thickness)) {
    drawLine(
        color = color,
        strokeWidth = thickness.toPx(),
        start = Offset(0f, thickness.toPx() / 2),
        end = Offset(size.width, thickness.toPx() / 2),
    )
}
