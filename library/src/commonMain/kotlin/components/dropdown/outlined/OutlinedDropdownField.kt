package components.dropdown.outlined

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import components.dropdown.DefaultDropDownTheme
import components.dropdown.DropDownStateObjImp
import components.dropdown.basic.BasicDropdownField
import components.dropdown.defaultDropdownTheme
import components.dropdown.getBorderDropdownByStateDefault
import data.model.DefaultInputState
import io.github.kotlin.components.buttons.rememberDefaultDropdownState
import io.github.kotlin.components.buttons.rememberDefaultInputState
import io.github.kotlin.data.model.Constants.OUTLINED_INPUT_DROPDOWN_ID

@Composable
fun <T>OutlinedDropdownField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "hint",
    label: String = "label",
    inputState: DefaultInputState = rememberDefaultInputState(),
    state: DropDownStateObjImp<T> = rememberDefaultDropdownState(),
    theme: DefaultDropDownTheme = defaultDropdownTheme(),
) {
    val combinedModifier = theme.defaultInputTheme.modifier
        .getBorderDropdownByStateDefault(inputState, theme.defaultInputTheme)
        .then(modifier)
        .testTag(OUTLINED_INPUT_DROPDOWN_ID)

    BasicDropdownField(
        modifier = combinedModifier,
        hintModifier = hintModifier,
        hint = hint,
        label = label,
        inputState = inputState,
        state = state,
        theme = theme,
    )
}