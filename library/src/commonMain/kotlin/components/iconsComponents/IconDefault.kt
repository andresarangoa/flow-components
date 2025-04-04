package components.iconsComponents

import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.content_description_arrows
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun IconDefault(
    modifier: Modifier = Modifier,
    iconTheme: IconTheme? = IconTheme(),
    isEnable: Boolean = true,
) {
    iconTheme?.icon?.let {
        Icon(
            painter = painterResource(
                it
            ),
            tint = iconTheme.getTintColor(isEnable = isEnable),
            modifier = modifier.getIconDefaultSize().testTag("DEFAULT_BUTTON_ICON_ID"),
            contentDescription = stringResource(Res.string.content_description_arrows)
        )
    }
}