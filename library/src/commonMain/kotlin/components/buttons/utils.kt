package io.github.kotlin.components.buttons

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import components.buttons.circular.DefaultCircularButtonImp
import components.dropdown.DropDownStateObjImp
import components.inputs.basic.DefaultInputStateImp
import data.model.DefaultInputState
import data.model.InputTypes

@Composable
fun <T> rememberDefaultDropdownState(
): DropDownStateObjImp<T> {
    return rememberSaveable(saver = DropDownStateObjImp.Saver()) {
        DropDownStateObjImp()
    }
}



@Composable
fun rememberDefaultCircularButtonState() = rememberSaveable(
    saver = DefaultCircularButtonImp.Saver
) { DefaultCircularButtonImp() }

@Composable
fun rememberDefaultInputState() = rememberSaveable(
    saver = DefaultInputStateImp.Saver
) { DefaultInputStateImp() }

inline fun <reified T : Any> Any?.checkType(): T? = if (this is T) this
else null


fun getVisualTransformation(state: DefaultInputState): VisualTransformation =
    if (state.showPassword && state.inputType == InputTypes.PASSWORD) PasswordVisualTransformation() else VisualTransformation.None

fun getKeyboardFromInputState(state: DefaultInputState): KeyboardOptions =
    when {
        state.inputType != InputTypes.PHONE -> {
            if (state.keyboardOptions == KeyboardOptions()) {
                KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text)
            } else {
                state.keyboardOptions
            }
        }
        else -> KeyboardOptions.Default.copy(keyboardType = KeyboardType.Phone)
    }