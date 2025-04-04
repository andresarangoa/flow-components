package data.model

import Country
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.text.KeyboardOptions
import org.jetbrains.compose.resources.DrawableResource


enum class InputTypes {
    PASSWORD, TEXT, PHONE
}
enum class IconVisibility {
    ALWAYS,
    ONLY_WHEN_FOCUSED,
    FOCUSED_AND_NOT_EMPTY,
    FOCUSED_OR_NOT_EMPTY
}

interface DefaultInputState {
    var isFocused: Boolean
    var iconVisibility: IconVisibility
    var text: String
    var onTextChanged: (text: String) -> Unit
    var hint: String
    var label: String
    var showHint: Boolean
    var showError: Boolean
    var showSuccess: Boolean
    var icon: DrawableResource?
    var onIconClick: () -> Unit
    var showPassword: Boolean
    var inputType: InputTypes
    var placeholder: String
    var readOnly: Boolean
    var selectedCountry: (country: Country?) -> Unit
    var keyboardOptions: KeyboardOptions
    var interactionSource: MutableInteractionSource
    var defaultCountryCode: String
    var canExpand: Boolean
    var enable: Boolean
    fun isValid(): Boolean
}