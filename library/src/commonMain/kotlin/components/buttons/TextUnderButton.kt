package components.buttons

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import io.github.kotlin.data.model.ConstantsValuesDp.value_dp_1
import io.github.kotlin.data.model.ConstantsValuesSp.value_sp_2

@Composable
fun TextUnderlinedButton(
    text: String,
    textStyle: TextStyle,
    color: Color,
    onClick: () -> Unit,
) {
    Text(
        modifier = Modifier
            .drawBehind {
                val strokeWidthPx = value_dp_1.toPx()
                val verticalOffset = size.height - value_sp_2.toPx()

                drawLine(
                    color = color,
                    strokeWidth = strokeWidthPx,
                    start = Offset(0f, verticalOffset),
                    end = Offset(size.width, verticalOffset)
                )
            }
            .clickable { onClick() },
        text = text,
        style = textStyle,
        fontWeight = FontWeight.Bold
    )
}
