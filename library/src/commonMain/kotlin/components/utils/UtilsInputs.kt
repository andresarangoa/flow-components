package components.utils

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import components.inputs.basic.DefaultInputTheme
import data.model.DefaultInputState
import data.model.IconVisibility
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp
import org.jetbrains.compose.resources.DrawableResource

@Composable
fun getSpacingWithIcon(state: DefaultInputState): Float = if (state.icon != null) 0.9f else 1f

@Composable
fun Modifier.modifierDecorationBoxBasic(state: DefaultInputState): Modifier {
    return this.then(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth(getSpacingWithIcon(state))
            .padding(start = ConstantsValuesDp.value_dp_8)
    )
}


@Composable
fun DefaultInputTheme.getHintStateColor(state: DefaultInputState): Color =
    if (state.showSuccess) this.iconSuccessColor else this.iconErrorColor

@Composable
fun DefaultInputTheme.getHintTextColor(state: DefaultInputState): Color =
    if (state.showSuccess || state.showError) this.getHintStateColor(state = state) else this.tint
        ?: Color.Gray

@Composable
fun DefaultInputTheme.getHintStateIcon(state: DefaultInputState): DrawableResource =
    if (state.showSuccess) this.iconSuccess else this.iconError

@Composable
fun DefaultInputTheme.getHintBorderColor(state: DefaultInputState, borderColor: Color): Color =
    if (state.showError || state.showSuccess) this.getHintStateColor(state = state) else borderColor


@Composable
fun Modifier.getBorderByStateDefault(state: DefaultInputState, theme: DefaultInputTheme): Modifier =
    if (state.isFocused) this.then(
        Modifier.border(
            theme.borderSizeFocused,
            theme.getHintBorderColor(state = state, borderColor = theme.borderColorFocused),
            MaterialTheme.shapes.small
        )
    )
    else this.then(
        Modifier.border(
            theme.borderSize,
            theme.getHintBorderColor(state = state, borderColor = theme.borderColor),
            MaterialTheme.shapes.small
        )
    )