package components.dropdown

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import components.AppColorScheme
import components.AppColors
import components.foundations.RobotoTypography
import components.inputs.basic.DefaultInputTheme
import io.github.kotlin.data.model.ConstantsValuesDp
import io.github.kotlin.data.model.ConstantsValuesDp.value_dp_2


data class DefaultDropDownTheme(
    var dropdownModifier: Modifier = Modifier,
    var defaultInputTheme: DefaultInputTheme,
    var backgroundInput: Color = AppColors.white,
    var tint: Color = AppColors.black
)

@Composable
fun defaultDropdownTheme(
    dropdownModifier: Modifier = Modifier,
    customColors: ProvidableCompositionLocal<AppColorScheme>? = null,
    width: Dp? = null,
    textStyle: TextStyle = RobotoTypography().bodyMedium.copy(
        customColors?.current?.textPrimary ?: Color.White
    )
) = DefaultDropDownTheme(
    defaultInputTheme = DefaultInputTheme(
        borderColor = customColors?.current?.borderSoft ?: Color.Unspecified,
        borderColorFocused = customColors?.current?.borderBold ?: Color.Unspecified,
        modifier = Modifier
            .padding(vertical = value_dp_2, horizontal = ConstantsValuesDp.value_dp_16)
            .then(if (width == null) Modifier.fillMaxWidth() else Modifier.width(width))
            .height(ConstantsValuesDp.value_dp_55)
            .clip(shape = MaterialTheme.shapes.small)
            .background(customColors?.current?.surfaceFilled ?: Color.White),
        hintModifier = Modifier.padding(
            vertical = ConstantsValuesDp.value_dp_4
        ),
        textStyle = textStyle
    ),
    backgroundInput = customColors?.current?.surfaceFilled ?: Color.White,
    dropdownModifier = dropdownModifier
)

@Composable
fun filledDropdownTheme(
    dropdownModifier: Modifier = Modifier,
    customColors: ProvidableCompositionLocal<AppColorScheme>? = null
) = DefaultDropDownTheme(
    defaultInputTheme = DefaultInputTheme(
        modifier = Modifier
            .padding(vertical = ConstantsValuesDp.value_dp_4)
            .clip(shape = MaterialTheme.shapes.small)
            .fillMaxWidth()
            .height(ConstantsValuesDp.value_dp_55),
        hintModifier = Modifier.padding(vertical = ConstantsValuesDp.value_dp_4),
//        textStyle = RobotoTypography.bodyMedium.copy(color = customColors.current.textPrimary),
    ),
    backgroundInput = customColors?.current?.surfaceFilled ?: Color.White,
    dropdownModifier = dropdownModifier,
)

