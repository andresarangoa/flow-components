package components.inputs.basic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import data.model.DefaultInputState
import io.github.kotlin.fibonacci.components.buttons.getKeyboardFromInputState
import io.github.kotlin.fibonacci.components.buttons.getVisualTransformation
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultInputState
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp

@Composable
fun BasicTextField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "",
    label: String = "",
    state: DefaultInputState = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme(),
) {
    state.hint = state.hint.ifBlank { hint }
    state.label = state.label.ifBlank { label }
        Column {
            Spacer(Modifier.height(ConstantsValuesDp.value_dp_5))
            BasicTextField(
                modifier = modifier.testTag("DEFAULT_INPUT_ID").onFocusChanged {
                    state.isFocused = it.isFocused
                },
                visualTransformation = getVisualTransformation(state),
                value = state.text,
                keyboardOptions = getKeyboardFromInputState(state),
                onValueChange = { newText ->
                    state.onTextChanged(newText)
                },
                decorationBox = { innerTextField ->
                    DecorationBoxBasicTextField(
                        innerTextField = innerTextField,
                        state = state,
                        theme = DefaultInputTheme(tint = theme.tint),
                    )
                },
                interactionSource = state.interactionSource,
                readOnly = state.readOnly,
                enabled = state.enable,
                singleLine = true,
                cursorBrush = SolidColor(theme.tint?: Color.Unspecified),
                textStyle = theme.textStyle,
            )
            HintInputField(
                state = state,
                modifier = hintModifier,
                theme = theme,
            )
        }
}