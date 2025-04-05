package components.inputs.outlined

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import components.inputs.basic.BasicTextField
import components.inputs.basic.DefaultInputTheme
import components.inputs.basic.defaultTheme
import components.utils.getBorderByStateDefault
import data.model.DefaultInputState
import io.github.kotlin.components.buttons.rememberDefaultInputState

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "",
    label: String = "",
    state: DefaultInputState = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme()
) {
    val combinedModifier = theme.modifier
        .getBorderByStateDefault(state, theme)
        .then(modifier)
        .testTag("OUTLINED_INPUT_ID")

    BasicTextField(
        modifier= combinedModifier,
        hintModifier= hintModifier,
        hint =hint,
        label =label,
        state =state,
        theme =theme,
    )
}