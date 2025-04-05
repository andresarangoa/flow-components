package components.dropdown.filled


import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import components.dropdown.DefaultDropDownTheme
import components.dropdown.filledDropdownTheme
import components.dropdown.DropDownStateObjImp
import components.dropdown.basic.BasicDropdownField
import data.model.DefaultInputState
import io.github.kotlin.components.buttons.rememberDefaultDropdownState
import io.github.kotlin.components.buttons.rememberDefaultInputState
import io.github.kotlin.data.model.Constants.FILLED_INPUT_DROPDOWN_ID

@Composable
fun<T> FilledDropdownField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "hint",
    label: String = "label",
    inputState: DefaultInputState = rememberDefaultInputState(),
    state: DropDownStateObjImp<T> = rememberDefaultDropdownState(),
    theme: DefaultDropDownTheme = filledDropdownTheme(),
) {
    val combinedModifier = theme.defaultInputTheme.modifier
        .then(modifier)
        .background(theme.backgroundInput)
        .testTag(FILLED_INPUT_DROPDOWN_ID)
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