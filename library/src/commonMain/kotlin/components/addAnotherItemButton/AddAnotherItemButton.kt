package io.github.kotlin.fibonacci.components.addAnotherItemButton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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

/**
 * A button with dashed border and "Add Another Item" text.
 * Works across Android and iOS platforms.
 *
 * @param modifier Modifier for the button
 * @param onAddClick The callback triggered when the button is clicked
 * @param text The text to display (defaults to "Add Another Item")
 * @param style The style parameters for the button (defaults to AddAnotherItemButtonStyle.Default)
 */
@Composable
fun AddAnotherItemButton(
    modifier: Modifier = Modifier,
    onAddClick: () -> Unit,
    text: String = "Add Another Item",
    style: AddAnotherItemButtonStyle = AddAnotherItemButtonStyle.Default
) {
    Box(
        modifier = modifier
            .padding(style.padding)
            .fillMaxWidth()
    ) {
        Button(
            onClick = onAddClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(style.height)
                .dashedBorder(
                    width = style.borderWidth,
                    color = style.borderColor,
                    shape = style.shape,
                    dashWidth = style.dashWidth,
                    dashGap = style.dashGap
                ),
            shape = style.shape,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = style.backgroundColor,
                contentColor = style.contentColor
            ),
            elevation = ButtonDefaults.elevation(
                defaultElevation = style.defaultElevation,
                pressedElevation = style.pressedElevation
            )
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add",
                modifier = Modifier.size(style.iconSize),
                tint = style.contentColor
            )
            Spacer(modifier = Modifier.width(style.spacerWidth))
            Text(
                text = text,
                color = style.contentColor
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