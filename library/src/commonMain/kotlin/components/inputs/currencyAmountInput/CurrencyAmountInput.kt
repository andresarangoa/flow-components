package components.inputs.currencyAmountInput

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import components.AppColors
import components.inputs.basic.DefaultInputTheme
import components.inputs.basic.HintInputField
import components.inputs.basic.defaultTheme
import components.inputs.basic.DecorationBoxBasicTextField
import data.model.DefaultInputState
import io.github.kotlin.fibonacci.DecimalFormatterI
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultInputState
import io.github.kotlin.fibonacci.data.model.Constants
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp.value_dp_5
import io.github.kotlin.fibonacci.getDecimalFormatter

@Composable
fun CurrencyAmountInputField(
    onValueChange: (String, Boolean) -> Unit,
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "",
    label: String = "",
    isHintDisplayed: Boolean = false,
    state: DefaultInputState = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme(),
    maxLength: Int = 11,
    textStyle: TextStyle = TextStyle()
) {
    val decimalFormatter = getDecimalFormatter()
    var numericValue by remember { mutableStateOf(state.text.removePrefix(Constants.LIMIT_SYMBOL_CURRENCY.toString())) }
    var textFieldValue by remember {
        mutableStateOf(
            TextFieldValue(
                text = state.text,
                selection = TextRange(numericValue.length)
            )
        )
    }
    var isHintDisplayed by remember { mutableStateOf(isHintDisplayed) }
    val currencySymbol = Constants.LIMIT_SYMBOL_CURRENCY

    val minCursorPosition = currencySymbol.toString().length
    Column {
        Spacer(Modifier.height(value_dp_5))
        BasicTextField(
            modifier = modifier.testTag("DEFAULT_INPUT_ID")
                .onFocusChanged {
                    state.isFocused = it.isFocused
                },
            visualTransformation = DecimalInputVisualTransformation(decimalFormatter),
            value = state.text,
            onValueChange = { newValue ->

                state.onTextChanged(newValue)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Decimal,
            ),
            textStyle = textStyle,
            cursorBrush = SolidColor(Color.Unspecified),
            decorationBox = { innerTextField ->
                DecorationBoxBasicTextField(
                    innerTextField = innerTextField,
                    state = state,
                    theme = DefaultInputTheme(tint = theme.tint),
                )
            }
        )
        HintInputField(
            state = state,
            modifier = hintModifier,
            theme = theme,
        )
    }
}

class DecimalInputVisualTransformation(
    private val decimalFormatter: DecimalFormatterI = getDecimalFormatter()
) : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val inputText = text.text
        val formattedNumber = decimalFormatter.formatForVisual(inputText)

        val newText = AnnotatedString(
            text = formattedNumber,
            spanStyles = text.spanStyles,
            paragraphStyles = text.paragraphStyles
        )

        val offsetMapping = FixedCursorOffsetMapping(
            contentLength = inputText.length,
            formattedContentLength = formattedNumber.length
        )

        return TransformedText(newText, offsetMapping)
    }
}

private class FixedCursorOffsetMapping(
    private val contentLength: Int,
    private val formattedContentLength: Int,
) : OffsetMapping {
    override fun originalToTransformed(offset: Int): Int = formattedContentLength
    override fun transformedToOriginal(offset: Int): Int = contentLength
}