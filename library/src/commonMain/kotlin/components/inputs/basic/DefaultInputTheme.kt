package components.inputs.basic

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.AppColorScheme
import components.AppColors
import components.foundation.CustomIconRes
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp.value_dp_16
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp.value_dp_2
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp.value_dp_4
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp.value_dp_80
import org.jetbrains.compose.resources.DrawableResource

data class DefaultInputTheme(
    var tint: Color? = Color.Gray,
    var textStyle: TextStyle = TextStyle(),
    var textErrorStyle: TextStyle = TextStyle(),
    var borderColorFocused: Color = Color.Gray,
    var borderColor: Color = Color.Gray,
    var borderSizeFocused: Dp = 2.dp,
    var borderSize: Dp = 1.dp,
    var fontSize: TextUnit = 10.sp,
    var modifier: Modifier = Modifier,
    var hintModifier: Modifier = Modifier,
    var iconSuccess: DrawableResource = CustomIconRes.checkCircleFilled,
    var iconError: DrawableResource = CustomIconRes.errorFilled,
    var iconSuccessColor: Color = AppColors.success700,
    var iconErrorColor: Color = AppColors.error600,
    var background: Color = AppColors.white,
    var visualTransformation: VisualTransformation = VisualTransformation.None,
    var height: Dp = 55.dp
)

@Composable
fun defaultTheme(
    paddingVertical:Dp = value_dp_4,
    paddingHorizontal: Dp= value_dp_16,
    customColors: ProvidableCompositionLocal<AppColorScheme>?= null,
) = DefaultInputTheme(
    borderColor = customColors?.current?.borderSoft?:Color.Unspecified,
    borderColorFocused = customColors?.current?.borderBold?:Color.Unspecified,
    modifier = Modifier
        .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
        .fillMaxWidth()
        .height(55.dp)
        .clip(shape = MaterialTheme.shapes.small)
        .background(customColors?.current?.surfacePrimary?:Color.Unspecified),
    hintModifier = Modifier.padding(
        horizontal = 16.dp, vertical = paddingVertical
    ),
    tint = customColors?.current?.textPrimary?:Color.Unspecified
)

@Composable
fun defaultThemeSlate(
    paddingVertical:Dp = value_dp_4,
    paddingHorizontal: Dp= value_dp_16,
    customColors: ProvidableCompositionLocal<AppColorScheme>?= null,
) = DefaultInputTheme(
    borderColor = customColors?.current?.quaternaryBorder?:Color.Unspecified,
    borderColorFocused = customColors?.current?.borderBold?:Color.Unspecified,
    modifier = Modifier
        .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
        .fillMaxWidth()
        .height(55.dp)
        .clip(shape = MaterialTheme.shapes.small)
        .background(customColors?.current?.surfaceQuaternary?:Color.Unspecified),
    hintModifier = Modifier.padding(
        horizontal = 16.dp, vertical = paddingVertical
    ),
    tint = customColors?.current?.textPrimary?:Color.Unspecified
)

@Composable
fun defaultHorizontalMinimumTheme(
    paddingVertical:Dp = value_dp_4,
    paddingHorizontal: Dp= value_dp_2,
    customColors: ProvidableCompositionLocal<AppColorScheme>?= null,
    width: Dp = value_dp_80,
    textErrorStyle: TextStyle = TextStyle()
) = DefaultInputTheme(
    textErrorStyle = textErrorStyle,
    borderColor = customColors?.current?.borderSoft?:Color.Unspecified,
    borderColorFocused = customColors?.current?.borderBold?:Color.Unspecified,
    modifier = Modifier
        .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
        .height(55.dp)
        .width(width)
        .clip(shape = MaterialTheme.shapes.small)
        .background(customColors?.current?.surfaceQuaternary?:Color.Unspecified),
    hintModifier = Modifier.padding(
        horizontal = 4.dp, vertical = paddingVertical
    ),
    tint = customColors?.current?.textPrimary?:Color.Unspecified
)
