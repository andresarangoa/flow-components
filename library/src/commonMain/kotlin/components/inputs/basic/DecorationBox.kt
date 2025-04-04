package components.inputs.basic

import CountryFlag
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import components.AppColors
import components.foundations.RobotoTypography
import components.inputs.dropDown.DropdownFlagsAndPhone
import components.inputs.dropDown.Padding
import data.model.DefaultInputState
import data.model.InputTypes
import io.github.kotlin.fibonacci.components.buttons.rememberDefaultInputState
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp
import components.iconsComponents.IconDefault
import components.iconsComponents.IconTheme
import components.utils.modifierDecorationBoxBasic
import data.model.IconVisibility

@Composable
internal fun DecorationBoxBasicTextField(
    modifier: Modifier = Modifier,
    state: DefaultInputState = rememberDefaultInputState(),
    theme: DefaultInputTheme = defaultTheme(),
    innerTextField: @Composable () -> Unit
) {
    Row(
        modifier = Modifier.padding(start = Padding.normal),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val isInputPhoneType = state.inputType == InputTypes.PHONE
        if (isInputPhoneType) {
            DropdownFlagsAndPhone(countries = CountryFlag, state = state)
            HorizontalSpacer()
        }
        Box(
            modifier = modifier
                .modifierDecorationBoxBasic(state)
                .weight(1f), // Use weight to fill remaining space
            contentAlignment = Alignment.CenterStart
        ) {
            Column {
                if (isInputPhoneType) {
                    Spacer(Modifier.height(ConstantsValuesDp.value_dp_14))
                }
                PlaceholderInput(state, modifier, theme)
                innerTextField()
            }
        }
        state.icon?.let {
            if (state.shouldShowIcon()) {
                Row {
                    Box(
                        modifier = Modifier
                            .padding(end = Padding.large)
                            .align(Alignment.CenterVertically), contentAlignment = Alignment.Center
                    ) {
                        IconDefault(iconTheme = IconTheme(
                            icon = it, tint = theme.tint
                        ), modifier = Modifier
                            .clickable {
                                state.onIconClick()
                            }
                            .size(ConstantsValuesDp.value_dp_19))
                    }
                }
            }
        }
    }
}

@Composable
fun HorizontalSpacer(
    width: Dp = ConstantsValuesDp.value_dp_2,
    height: Dp = ConstantsValuesDp.value_dp_12,
    color: Color = AppColors.neutral200
) {
    Box(
        modifier = Modifier
            .testTag("SPACER")
            .padding(top = ConstantsValuesDp.value_dp_15)
            .size(width = width, height = height)
            .background(color)
    )
}

@Composable
fun PlaceholderInput(
    state: DefaultInputState,
    modifier: Modifier,
    theme: DefaultInputTheme = defaultTheme(),
    textStyle: TextStyle = RobotoTypography().bodySmall.copy(color = theme.labelColor)
) {
    if (state.isLabelVisible()) {
        if (state.inputType != InputTypes.PHONE) {
            Text(
                text = state.label,
                style = textStyle
            )
        }
    } else {
        Box(
            modifier = modifier.modifierDecorationBoxBasic(state),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = state.label,
                style =textStyle
            )
        }
    }
}


fun DefaultInputState.shouldShowIcon(): Boolean {
    return when (this.iconVisibility) {
        IconVisibility.ALWAYS -> true
        IconVisibility.ONLY_WHEN_FOCUSED -> this.isFocused
        IconVisibility.FOCUSED_OR_NOT_EMPTY -> this.isFocused || (!this.isFocused && this.text.isNotEmpty())
        IconVisibility.FOCUSED_AND_NOT_EMPTY -> this.isFocused && this.text.isNotEmpty()
    }
}

fun DefaultInputState.isLabelVisible() = (this.isFocused || this.text.isNotEmpty())
