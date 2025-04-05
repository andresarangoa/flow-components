package components.temporaryInputs

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import components.AppColorScheme
import io.github.andresarangoa.library.generated.resources.Res
import io.github.andresarangoa.library.generated.resources.ic_clear
import io.github.andresarangoa.library.generated.resources.ic_password_visible_off
import io.github.andresarangoa.library.generated.resources.ic_password_visible_on
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailInputField(
    modifier: Modifier = Modifier,
    value: String,
    labelString: String,
    onEmailChanged: (String) -> Unit,
    onEmailCleared: () -> Unit,
    errorText: String = "invalid mail",
    isError: Boolean = false,
    localCustomColorsPalette: ProvidableCompositionLocal<AppColorScheme>
) {
    Column {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onEmailChanged(it)
            },
            modifier = modifier
                .fillMaxWidth(),
            label = { Text(text = labelString) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Email
            ),
            isError = isError,
            trailingIcon = {
                ClearIcon {
                    onEmailCleared()
                }
            },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = localCustomColorsPalette.current.surfaceQuaternaryInput,
                unfocusedContainerColor = localCustomColorsPalette.current.surfaceQuaternaryInput,
                errorContainerColor = localCustomColorsPalette.current.surfaceQuaternaryInput,
                focusedTextColor = localCustomColorsPalette.current.textPrimary,
                unfocusedTextColor = localCustomColorsPalette.current.quaternaryBorder,
                disabledTextColor = localCustomColorsPalette.current.textDisable,
                cursorColor = localCustomColorsPalette.current.textPrimary,
                errorCursorColor = localCustomColorsPalette.current.textError,
                focusedIndicatorColor = localCustomColorsPalette.current.textPrimary,
                unfocusedIndicatorColor = localCustomColorsPalette.current.quaternaryBorder,
                disabledIndicatorColor = localCustomColorsPalette.current.textDisable,
                errorIndicatorColor = localCustomColorsPalette.current.textError,
                focusedLabelColor = localCustomColorsPalette.current.textPrimary,
                unfocusedLabelColor = localCustomColorsPalette.current.textPrimary,
                disabledLabelColor = localCustomColorsPalette.current.textDisable,
                errorLabelColor = localCustomColorsPalette.current.textError,
            )
        )
        if (isError) Text(
            text = errorText,
            color = Color.Red,
//                style = MaterialTheme.typography.
        )
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ClearIcon(onClick: () -> Unit) {
    Icon(
        painter = painterResource(Res.drawable.ic_clear),
        modifier = Modifier.clickable {
            onClick()
        },
        contentDescription = ""
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordInputField(
    modifier: Modifier = Modifier,
    value: String,
    onPasswordChanged: (String) -> Unit,
    onNextClicked: () -> Unit = {},
    labelString: String = "password",
    hintId: String? = null,
    errorText: String = "invalid Password",
    isError: Boolean = false,
    localCustomColorsPalette: ProvidableCompositionLocal<AppColorScheme>
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = value,
            onValueChange = {
                onPasswordChanged(it)
            },
            modifier = modifier.fillMaxWidth(),
            label = { Text(text = labelString) },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = if (passwordVisible) {
                VisualTransformation.None
            } else PasswordVisualTransformation(),
            isError = isError,
            keyboardActions = KeyboardActions(
                onDone = {
                    onNextClicked()
                }
            ),
            trailingIcon = {
                val iconSource = if (passwordVisible) {
                    Res.drawable.ic_password_visible_on
                } else Res.drawable.ic_password_visible_off

                Icon(
                    modifier = Modifier.clickable { passwordVisible = !passwordVisible },
                    painter = painterResource(iconSource),
                    tint = if (isError) {
                        localCustomColorsPalette.current.textError
                    } else {
                        localCustomColorsPalette.current.textPrimary
                    },
                    contentDescription = ""
                )
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = localCustomColorsPalette.current.surfaceQuaternaryInput,
                unfocusedContainerColor = localCustomColorsPalette.current.surfaceQuaternaryInput,
                errorContainerColor = localCustomColorsPalette.current.surfaceQuaternaryInput,
                focusedTextColor = localCustomColorsPalette.current.textPrimary,
                unfocusedTextColor = localCustomColorsPalette.current.quaternaryBorder,
                disabledTextColor = localCustomColorsPalette.current.textDisable,
                cursorColor = localCustomColorsPalette.current.textPrimary,
                errorCursorColor = localCustomColorsPalette.current.textError,
                focusedIndicatorColor = localCustomColorsPalette.current.textPrimary,
                unfocusedIndicatorColor = localCustomColorsPalette.current.quaternaryBorder,
                disabledIndicatorColor = localCustomColorsPalette.current.textDisable,
                errorIndicatorColor = localCustomColorsPalette.current.textError,
                focusedLabelColor = localCustomColorsPalette.current.textPrimary,
                unfocusedLabelColor = localCustomColorsPalette.current.textPrimary,
                disabledLabelColor = localCustomColorsPalette.current.textDisable,
                errorLabelColor = localCustomColorsPalette.current.textError,
            ),
            singleLine = true
        )
        if (isError) {
            Text(
                text = errorText,
                color = localCustomColorsPalette.current.textError
            )
        } else if (null != hintId) {
            Text(
                text = hintId,
                color = localCustomColorsPalette.current.textSecondary
            )
        }
    }
}