package components.dropdown

import androidx.compose.foundation.border
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import components.inputs.basic.DefaultInputTheme
import data.model.DefaultInputState

@Composable
fun Modifier.getBorderDropdownByStateDefault(
    state: DefaultInputState,
    theme: DefaultInputTheme,
): Modifier =
    if (state.isFocused) this.then(
        Modifier.border(
            theme.borderSizeFocused,
            theme.getHintDropdownBorderColor(state = state, borderColor = theme.borderColorFocused),
            MaterialTheme.shapes.small,
        ),
    )
    else this.then(
        Modifier.border(
            theme.borderSize,
            theme.getHintDropdownBorderColor(state = state, borderColor = theme.borderColor),
            MaterialTheme.shapes.small,
        ),
    )

@Composable
fun DefaultInputTheme.getHintDropdownStateColor(state: DefaultInputState): Color =
    if (state.showSuccess) this.iconSuccessColor else this.iconErrorColor
@Composable
fun DefaultInputTheme.getHintDropdownBorderColor(state: DefaultInputState, borderColor: Color): Color =
    if (state.showError) this.getHintDropdownStateColor(state = state) else borderColor
