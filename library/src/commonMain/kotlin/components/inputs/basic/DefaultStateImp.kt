package components.inputs.basic

import Country
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue
import data.model.DefaultInputState
import data.model.IconVisibility
import data.model.InputTypes
import io.github.kotlin.fibonacci.components.buttons.checkType
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_COUNTRY_CODE_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_ENABLE
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_FOCUSABLE
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_HIDE_IS_NOT_FOCUS
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_HINT_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_ICON_CLICK_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_ICON_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_INTERACTION_SOURCE
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_IS_FOCUSED_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_KEYBOARD_OPTIONS
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_LABEL_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_ON_TEXT_CHANGED_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_SELECTED_COUNTRY_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_SHOW_ERROR_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_SHOW_HINT_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_SHOW_PASSWORD_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_SHOW_SUCCESS_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_TEXT_AREA_PLACEHOLDER_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_TEXT_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DEFAULT_INPUT_TYPE_INDEX
import io.github.kotlin.fibonacci.data.model.Constants.DROPDOWN_CAN_EXPANDED_CODE_INDEX
import org.jetbrains.compose.resources.DrawableResource

class DefaultInputStateImp(
    isFocused: Boolean = false,
    text: String = "",
    onTextChanged: (text: String) -> Unit = {},
    hint: String = "",
    label: String = "",
    showHint: Boolean = false,
    showError: Boolean = false,
    showSuccess: Boolean = false,
    icon: DrawableResource? = null,
    placeholder: String = "",
    onIconClick: () -> Unit = {},
    showPassword: Boolean = true,
    inputType: InputTypes = InputTypes.TEXT,
    selectedCountry: (country: Country?) -> Unit = {},
    readOnly: Boolean = false,
    iconVisibility: IconVisibility = IconVisibility.ALWAYS,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    interactionSource: MutableInteractionSource = MutableInteractionSource(),
    defaultCountryCode: String = "US",
    canExpand: Boolean = true,
    enable: Boolean = true
) : DefaultInputState {
    override var isFocused: Boolean by mutableStateOf(isFocused)
    override var text: String by mutableStateOf(text)
    override var onTextChanged: (text: String) -> Unit by mutableStateOf(onTextChanged)
    override var hint: String by mutableStateOf(hint)
    override var label: String by mutableStateOf(label)
    override var showHint: Boolean by mutableStateOf(showHint)
    override var showError: Boolean by mutableStateOf(showError)
    override var showSuccess: Boolean by mutableStateOf(showSuccess)
    override var icon: DrawableResource? by mutableStateOf(icon)
    override var placeholder: String by mutableStateOf(placeholder)
    override var onIconClick: () -> Unit by mutableStateOf(onIconClick)
    override var showPassword: Boolean by mutableStateOf(showPassword)
    override var inputType: InputTypes by mutableStateOf(inputType)
    override var selectedCountry: (country: Country?) -> Unit by mutableStateOf(selectedCountry)
    override var readOnly: Boolean by mutableStateOf(readOnly)
    override var iconVisibility: IconVisibility by mutableStateOf(iconVisibility)
    override var keyboardOptions: KeyboardOptions by mutableStateOf(keyboardOptions)
    override var interactionSource: MutableInteractionSource by mutableStateOf(interactionSource)
    override var defaultCountryCode: String by mutableStateOf(defaultCountryCode)
    override var canExpand: Boolean by mutableStateOf(canExpand)
    override var enable: Boolean by mutableStateOf(enable)

    override fun isValid(): Boolean = text.isNotEmpty()

    internal companion object {
        val Saver = Saver<DefaultInputStateImp, List<Any?>>(save = {
            listOf(
                it.isFocused,
                it.text,
                it.onTextChanged,
                it.hint,
                it.label,
                it.showHint,
                it.showError,
                it.showSuccess,
                it.icon,
                it.placeholder,
                it.onIconClick,
                it.showPassword,
                it.inputType,
                it.selectedCountry,
                it.readOnly,
                it.iconVisibility,
                it.keyboardOptions,
                it.interactionSource,
                it.defaultCountryCode,
                it.canExpand,
                it.enable
            )
        },
            restore = { restore(it) })

        private fun restore(it: List<Any?>): DefaultInputStateImp {
            return DefaultInputStateImp(
                it[DEFAULT_INPUT_IS_FOCUSED_INDEX] as Boolean,
                it[DEFAULT_INPUT_TEXT_INDEX] as String,
                it[DEFAULT_INPUT_ON_TEXT_CHANGED_INDEX].checkType<(text: String) -> Unit>() as (text: String) -> Unit,
                it[DEFAULT_INPUT_LABEL_INDEX] as String,
                it[DEFAULT_INPUT_HINT_INDEX] as String,
                it[DEFAULT_INPUT_SHOW_HINT_INDEX] as Boolean,
                it[DEFAULT_INPUT_SHOW_ERROR_INDEX] as Boolean,
                it[DEFAULT_INPUT_SHOW_SUCCESS_INDEX] as Boolean,
                it[DEFAULT_INPUT_ICON_INDEX] as DrawableResource?,
                it[DEFAULT_INPUT_TEXT_AREA_PLACEHOLDER_INDEX] as String,
                it[DEFAULT_INPUT_ICON_CLICK_INDEX].checkType<() -> Unit>() as () -> Unit,
                it[DEFAULT_INPUT_SHOW_PASSWORD_INDEX] as Boolean,
                it[DEFAULT_INPUT_TYPE_INDEX] as InputTypes,
                it[DEFAULT_INPUT_SELECTED_COUNTRY_INDEX].checkType<(country: Country?) -> Unit>() as (country: Country?) -> Unit,
                it[DEFAULT_INPUT_FOCUSABLE] as Boolean,
                it[DEFAULT_INPUT_HIDE_IS_NOT_FOCUS] as IconVisibility,
                it[DEFAULT_INPUT_KEYBOARD_OPTIONS] as KeyboardOptions,
                it[DEFAULT_INPUT_INTERACTION_SOURCE] as MutableInteractionSource,
                it[DEFAULT_COUNTRY_CODE_INDEX] as String,
                it[DROPDOWN_CAN_EXPANDED_CODE_INDEX] as Boolean,
                it[DEFAULT_INPUT_ENABLE] as Boolean,
            )
        }
    }
}