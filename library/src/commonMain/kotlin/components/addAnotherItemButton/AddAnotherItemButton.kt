package io.github.kotlin.fibonacci.components.addAnotherItemButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.addOutline
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Constants for reuse
object ButtonConstants {
    val PADDING = 16.dp
    val HEIGHT = 56.dp
    val BORDER_WIDTH = 1.dp
    val CORNER_RADIUS = 8.dp
    val DASH_WIDTH = 4.dp
    val DASH_GAP = 4.dp
    val ICON_SIZE = 16.dp
    val SPACER_WIDTH = 8.dp

    // Colors
    val BUTTON_TEXT_COLOR = Color(0xFF6F7A8B)
    val SURFACE_COLOR = Color(0xFFF6F7F9) // Light background color
    val BORDER_COLOR = Color(0xFFCBD2E0) // Border color
}

/**
 * A button with dashed border and "Add Another Item" text.
 * Works across Android and iOS platforms.
 *
 * @param modifier Modifier for the button
 * @param onAddClick The callback triggered when the button is clicked
 * @param text The text to display (defaults to "Add Another Item")
 */
@Composable
fun AddAnotherItemButton(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit,
    text: String = "Add Another Item"
) {
    Box(
        modifier = modifier
            .padding(ButtonConstants.PADDING)
            .fillMaxWidth()
    ) {
        Button(
            onClick = onAddClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(ButtonConstants.HEIGHT)
                .dashedBorder(
                    width = ButtonConstants.BORDER_WIDTH,
                    color = ButtonConstants.BORDER_COLOR,
                    shape = RoundedCornerShape(ButtonConstants.CORNER_RADIUS),
                    dashWidth = ButtonConstants.DASH_WIDTH,
                    dashGap = ButtonConstants.DASH_GAP
                ),
            shape = RoundedCornerShape(ButtonConstants.CORNER_RADIUS),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = ButtonConstants.SURFACE_COLOR,
                contentColor = ButtonConstants.BUTTON_TEXT_COLOR
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 0.dp,
                pressedElevation = 0.dp
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.size(ButtonConstants.ICON_SIZE),
                tint = ButtonConstants.BUTTON_TEXT_COLOR
            )
            Spacer(modifier = Modifier.width(ButtonConstants.SPACER_WIDTH))
            Text(
                text = text,
                color = ButtonConstants.BUTTON_TEXT_COLOR
            )
        }
    }
}

/**
 * A modifier extension that adds a dashed border to any composable.
 *
 * @param width Width of the border stroke
 * @param color Color of the border
 * @param shape Shape of the border (rounded rectangle, circle, etc.)
 * @param dashWidth Width of each dash in the dashed line
 * @param dashGap Gap between dashes
 */
fun Modifier.dashedBorder(
    width: Dp,
    color: Color,
    shape: Shape,
    dashWidth: Dp,
    dashGap: Dp
) = this.then(
    Modifier.drawWithContent {
        drawContent()

        val stroke = Stroke(
            width = width.toPx(),
            pathEffect = PathEffect.dashPathEffect(
                intervals = floatArrayOf(dashWidth.toPx(), dashGap.toPx()),
                phase = 0f
            )
        )

        drawIntoCanvas { canvas ->
            val path = Path().apply {
                addOutline(
                    shape.createOutline(
                        size = size,
                        layoutDirection = layoutDirection,
                        density = this@drawWithContent
                    )
                )
            }
            canvas.drawPath(path, androidx.compose.ui.graphics.Paint().apply {
                this.color = color
                this.style = PaintingStyle.Stroke
                this.pathEffect = stroke.pathEffect
                this.strokeWidth = stroke.width
            })
        }
    }
)