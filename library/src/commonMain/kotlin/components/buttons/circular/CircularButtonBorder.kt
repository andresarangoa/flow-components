package components.buttons.circular

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import data.model.DefaultCircularButtonState
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultCircularButtonState

@Composable
fun CircularButtonBorder(
    modifier: Modifier = Modifier,
    theme: DefaultCircularButtonTheme = defaultCircularWithBorderButtonTheme(),
    state: DefaultCircularButtonState = rememberDefaultCircularButtonState()
) {
    val combinedModifier = theme.modifier
        .then(modifier)
        .testTag("BORDER_CIRCULAR_BUTTON_ID")

        DefaultCircleButton(
            modifier = combinedModifier,
            theme = theme,
            state = state
        )
}