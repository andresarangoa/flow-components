package org.app.controlbill.components.inputs.underline

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import components.AppColorScheme
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp

@Composable
fun UnderlinedTextInputWithCheckbox(
    text: String,
    onTextChanged: (String) -> Unit,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "Enter text",
    customColors: ProvidableCompositionLocal<AppColorScheme>?= null,
    textStyle: TextStyle = TextStyle()
) {
    val primaryColor = customColors?.current?.textPrimary?:Color.Unspecified
    val secondaryColor = customColors?.current?.textSecondary
    val opacity = if(isSystemInDarkTheme()) 0.9f else 0.1f

    // Define percentage text color based on theme
    val percentageColor = if(isSystemInDarkTheme()) {
        Color(0xFFCCDDFF)  // Brighter color for dark theme
    } else {
        Color(0xFF2C3E50)  // Darker color for light theme
    }

    // Define border color based on theme
    val borderColor = if(isSystemInDarkTheme()) {
        Color(0xFF5D7096)  // Visible border in dark theme
    } else {
        Color(0xFF8EA4C1)  // Visible border in light theme
    }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = ConstantsValuesDp.value_dp_8)
            .background(
                color = customColors?.current?.surfaceOnPrimary?.copy(alpha = opacity)?:Color.Unspecified,
                shape = RoundedCornerShape(ConstantsValuesDp.value_dp_12)
            )
            .padding(
                horizontal = ConstantsValuesDp.value_dp_16,
                vertical = ConstantsValuesDp.value_dp_12
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Left side with Switch and label
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Custom sized switch
            Box(
                modifier = Modifier
                    .size(width = ConstantsValuesDp.value_dp_36, height = ConstantsValuesDp.value_dp_20)
                    .background(
                        color = if (checked) Color(0xFF6F7A8B) else Color.LightGray,
                        shape = RoundedCornerShape(ConstantsValuesDp.value_dp_10)
                    )
                    .clickable { onCheckedChange(!checked) },
                contentAlignment = if (checked) Alignment.CenterEnd else Alignment.CenterStart
            ) {
                Box(
                    modifier = Modifier
                        .padding(horizontal = ConstantsValuesDp.value_dp_2)
                        .size(ConstantsValuesDp.value_dp_16)
                        .background(Color.White, CircleShape)
                )
            }
            Spacer(modifier = Modifier.width(ConstantsValuesDp.value_dp_8))
            Text(
                text = "Includes Service?",
                style = textStyle
            )
        }

        // Right side with percentage or "Percentage" placeholder
        if (checked) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .border(
                        width = ConstantsValuesDp.value_dp_1,
                        color = borderColor,
                        shape = RoundedCornerShape(ConstantsValuesDp.value_dp_4)
                    )
                    .padding(horizontal = ConstantsValuesDp.value_dp_8, vertical = ConstantsValuesDp.value_dp_8)
            ) {
                // Show cursor indicator and make input more obvious
                BasicTextField(
                    value = text,
                    onValueChange = onTextChanged,
                    textStyle = textStyle.copy(
                        color = percentageColor,
                        textAlign = TextAlign.End
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Decimal
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .width(ConstantsValuesDp.value_dp_36)
                        .background(
                            color = if(isSystemInDarkTheme()) Color(0xFF2A3547) else Color(0xFFF5F8FC),
                            shape = RoundedCornerShape(ConstantsValuesDp.value_dp_2)
                        )
                        .padding(horizontal = ConstantsValuesDp.value_dp_4, vertical = ConstantsValuesDp.value_dp_2)
                )
                Spacer(modifier = Modifier.width(ConstantsValuesDp.value_dp_2))
                Text(
                    text = "%",
                    style = textStyle,
                    color = percentageColor
                )
            }
        } else {
            Text(
                text = "Percentage",
                style = textStyle,
                color = secondaryColor?:Color.Unspecified
            )
        }
    }
}
