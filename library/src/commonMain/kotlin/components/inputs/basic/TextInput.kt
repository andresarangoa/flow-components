package components.inputs.basic

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp.value_dp_8
import components.inputs.outlined.OutlinedTextField

@Composable
fun TextInputField(
    modifier: Modifier = Modifier,
    value: String,
    label: String,
    errorText: String,
    onTextChanged: (String) -> Unit,
    onTextCleared: () -> Unit,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    hint: String? = null,
    isReadOnly: Boolean = false,
    isError: Boolean = false,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    roundedShape: Dp = value_dp_8
) {
   OutlinedTextField(

   )
}
