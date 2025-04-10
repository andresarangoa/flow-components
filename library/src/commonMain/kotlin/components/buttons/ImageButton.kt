package components.buttons

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun ImageButton(
    drawableRes: DrawableResource,
    contentDescription: String = "",
    modifier: Modifier = Modifier,
    tint: Color = Color.Black,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .size(32.dp, 32.dp)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            modifier = Modifier.size(40.dp),
            painter = painterResource(drawableRes),
            tint = tint,
            contentDescription = contentDescription
        )
    }
}
