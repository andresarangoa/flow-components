package components.dropdown.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import components.dropdown.DefaultDropDownTheme
import components.dropdown.defaultDropdownTheme
import components.inputs.basic.BasicTextField

import components.dropdown.DropDownStateObjImp
import data.model.DefaultInputState
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultDropdownState
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultInputState
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_DROPDOWN_ID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun <T> BasicDropdownField(
    modifier: Modifier = Modifier,
    hintModifier: Modifier = Modifier,
    hint: String = "hint",
    label: String = "label",
    inputState: DefaultInputState = rememberDefaultInputState(),
    state: DropDownStateObjImp<T> = rememberDefaultDropdownState(), // Default display function
    theme: DefaultDropDownTheme = defaultDropdownTheme(),
) {
    var isExpanded by remember { mutableStateOf(false) }
    inputState.hint = hint
    inputState.label = label
    inputState.readOnly = true
    inputState.onIconClick = {
        isExpanded = inputState.canExpand
    }

    if(state.selectedOption != null){
        inputState.text = state.selectedOption?.let {
            state.displayProperty(it) } ?: ""
    }

    Column {
        ExposedDropdownMenuBox(
            expanded = isExpanded && inputState.canExpand,
            onExpandedChange = {
                if (inputState.canExpand) isExpanded = it
            },
        ) {
            BasicTextField(
                modifier = modifier
                    .testTag(DEFAULT_INPUT_DROPDOWN_ID)
                    .then(Modifier.menuAnchor()),
                hintModifier = hintModifier,
                hint = hint,
                label = label,
                state = inputState,
                theme = theme.defaultInputTheme,
            )
            DropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false },
                modifier = theme.dropdownModifier
                    .background(color = theme.backgroundInput)
                    .exposedDropdownSize(),
            ) {
                state.dropdownOptionList.forEach { option ->
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = state.displayProperty(option),
                                style = theme.defaultInputTheme.textStyle,
                            )
                        },
                        onClick = {
                            state.onSelectedOption(option)
                            state.selectedOption = option
                            val text = state.displayProperty(option)

                            inputState.text = text
                            isExpanded = false
                        }
                    )
                }
                if (state.showAddNew && state.onAddNew != null) {
                    DropdownMenuItem(
                        text = {
                            Text(
                                text = state.addNewText ?: "Add New",
                                style = theme.defaultInputTheme.textStyle,
                            )
                        },
                        onClick = {
                            state.onAddNew?.let { it() }
                            isExpanded = false
                        }
                    )
                }
            }
        }
    }
}

