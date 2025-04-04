package components.iconsComponents
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AppColors
import org.jetbrains.compose.resources.DrawableResource

enum class IconDirection {
    LEFT, RIGHT
}

@Composable
fun IconTheme.getTintColor(isEnable: Boolean): Color =
    if (isEnable) this.tint ?: Color.Unspecified else (this.disableTint
        ?: AppColors.black)

object Size {
    val small = 4.dp
    val normal = 8.dp
    val large = 16.dp
    val xLarge = 24.dp
    val icon = 40.dp
    val primaryButtonIcon = 15.dp
    object DefaultButtonSize {
        val width = 400.dp
        val height = 50.dp
        val fontSize = 12.sp
    }
}


@Composable
fun Modifier.getIconDefaultSize(): Modifier = this.then(Modifier.size(Size.primaryButtonIcon))
data class IconTheme(
    var icon: DrawableResource? = null,
    var tint: Color? = null,
    var disableTint: Color? = null
) {
    companion object {
        @Composable
        fun onSecondary(icon: DrawableResource?) = IconTheme(
            icon = icon,
            tint = AppColors.black,
            disableTint = AppColors.neutral200
        )

        @Composable
        fun onPrimary(icon: DrawableResource?) = IconTheme(
            icon = icon,
            tint = AppColors.black,
            disableTint = AppColors.neutral200
        )
    }
}
