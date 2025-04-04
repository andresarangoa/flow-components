package components.inputs.currencyAmountInput

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import components.inputs.basic.DefaultInputTheme
import components.inputs.basic.defaultTheme
import components.utils.getBorderByStateDefault
import data.model.DefaultInputState
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultInputState

@Composable
fun OutlinedCurrencyAmountInput(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "",
    label: String = "",
    onValueChange: (String, Boolean) -> Unit,
    state: DefaultInputState = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme()
) {
    val combinedModifier = theme.modifier
        .getBorderByStateDefault(state, theme)
        .then(modifier)
        .testTag("OUTLINED_INPUT_ID")

    CurrencyAmountInputField(
        modifier= combinedModifier,
        hintModifier= hintModifier,
        hint =hint,
        label =label,
        state =state,
        theme =theme,
        onValueChange = onValueChange
    )
}