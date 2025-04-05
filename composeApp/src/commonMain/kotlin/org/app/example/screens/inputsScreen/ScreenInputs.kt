package org.app.example.screens.inputsScreen

import Country
import CountryFlag
import ScreenInputsComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import components.dropdown.DropDownStateObjImp
import components.dropdown.defaultDropdownTheme
import components.dropdown.outlined.OutlinedDropdownField
import components.foundation.CustomIconRes
import components.inputs.basic.DefaultInputStateImp
import components.inputs.basic.defaultTheme
import components.inputs.outlined.OutlinedTextField
import data.model.IconVisibility
import io.github.kotlin.data.model.ConstantsValuesDp
import org.app.example.components.FlowUITheme
import org.app.example.components.LocalCustomColorsPaletteFlow

@Composable
fun ScreenInputs(component: ScreenInputsComponent) {
    var value by remember { mutableStateOf("") }
    val isValidValue by remember { mutableStateOf(true) }
    val options = remember {
        listOf("Option 1", "Option 2", "Option 3", "Option 4", "Option 5")
    }
    var selectedOption by remember { mutableStateOf("") }

    val dropdownState = remember {
        DropDownStateObjImp(
            // Display the string as is
            displayProperty = { option -> option },
            // The list of options
            dropdownOptionList = options,
            // Handle selection
            onSelectedOption = { option ->
                selectedOption = option
            }
        )
    }

    FlowUITheme {
        Column(
            modifier = Modifier.background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
                .fillMaxSize()
                .padding(top =ConstantsValuesDp.value_dp_16)
        ) {
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
                    icon = CustomIconRes.cancel,
                    onIconClick = { value = "" }
                ),
                theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
                hint = "test",
                label = "test"
            )

            OutlinedTextField(
                state = DefaultInputStateImp(
                    text = value,
                    showError = isValidValue,
                    onTextChanged = {
                        value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
                    icon = CustomIconRes.cancel,
                    onIconClick = { value = "" }
                ),
                theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
                hint = "test",
                label = "test"
            )

            OutlinedTextField(
                state = DefaultInputStateImp(
                    text = value,
                    showSuccess = isValidValue,
                    onTextChanged = {
                        value = it
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    iconVisibility = IconVisibility.FOCUSED_OR_NOT_EMPTY,
                    icon = CustomIconRes.cancel,
                    onIconClick = { value = "" }
                ),
                theme = defaultTheme(customColors = LocalCustomColorsPaletteFlow),
                hint = "test",
                label = "test"
            )

            OutlinedDropdownField(
                label = "Select an option",
                hint = "Please select an option",
                inputState = DefaultInputStateImp(
                    text = selectedOption
                ),
                state = dropdownState,
                theme = defaultDropdownTheme(customColors = LocalCustomColorsPaletteFlow)
            )
        }
    }
}