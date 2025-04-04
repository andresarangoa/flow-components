package org.app.example.screens.inputsScreen

import ScreenInputsComponent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import components.inputs.basic.DefaultInputStateImp
import components.inputs.basic.defaultTheme
import components.inputs.outlined.OutlinedTextField
import data.model.IconVisibility
import org.app.example.components.LocalCustomColorsPaletteFlow

@Composable
fun ScreenInputs(component: ScreenInputsComponent) {
    var value by remember { mutableStateOf("") }
    val isValidValue by remember { mutableStateOf(true) }
    Column(modifier = Modifier.fillMaxSize()) {
        OutlinedTextField(
            state = DefaultInputStateImp(
                text = value,
                showError = !isValidValue,
                onTextChanged = {
                    value = it
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
//                icon = Res.drawable.ic_clear,
                onIconClick = { value = "" }
            ),
            theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
            hint =  "test",
            label = "test"
        )
    }
}