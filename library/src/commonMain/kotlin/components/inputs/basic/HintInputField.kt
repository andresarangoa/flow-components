package components.inputs.basic


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import components.utils.getHintStateColor
import components.utils.getHintStateIcon
import components.utils.getHintTextColor
import data.model.DefaultInputState
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.content_description_arrows
import io.github.kotlin.components.buttons.rememberDefaultInputState
import io.github.kotlin.data.model.ConstantsValuesDp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun HintInputField(
    modifier: Modifier = Modifier,
    state: DefaultInputState = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme()
) {
    val combinedHintModifier = theme.hintModifier.then(modifier)

    Row(modifier = combinedHintModifier) {
        when {
            state.showHint -> HintText(state.hint, theme, state)
            state.showError || state.showSuccess -> {
                FeedbackIcon(state, theme)
                HintText(state.hint, theme, state)
            }
        }
    }
}

@Composable
fun HintText(hint: String, theme: DefaultInputTheme, state: DefaultInputState) {
    Text(
        text = hint,
        color = theme.getHintTextColor(state),
        style = theme.textErrorStyle
    )
}

@Composable
fun FeedbackIcon(state: DefaultInputState, theme: DefaultInputTheme) {
    Icon(
        painter = painterResource(theme.getHintStateIcon(state)),
        contentDescription = stringResource(Res.string.content_description_arrows),
        tint = theme.getHintStateColor(state),
        modifier = Modifier.size(ConstantsValuesDp.value_dp_15)
    )
}
