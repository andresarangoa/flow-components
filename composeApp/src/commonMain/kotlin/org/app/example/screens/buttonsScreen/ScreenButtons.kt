package org.app.example.screens.buttonsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.kotlin.fibonacci.components.addAnotherItemButton.AddAnotherItemButton
import io.github.kotlin.fibonacci.components.addAnotherItemButton.AddAnotherItemButtonStyle
import io.github.kotlin.fibonacci.components.buttons.GradientButton
import io.github.kotlin.fibonacci.components.buttons.RoundedCornerFilledButton
import io.github.kotlin.fibonacci.components.buttons.RoundedCornerOutlinedButton
import io.github.kotlin.fibonacci.data.model.ConstantsValuesDp
import org.app.example.components.FlowUITheme
import org.app.example.components.LocalCustomColorsPaletteFlow

@Composable
fun ScreenButtons(component: ScreenButtonComponent) {

    FlowUITheme {
        Column(
            modifier = Modifier.background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
                .fillMaxSize()
                .padding(ConstantsValuesDp.value_dp_16)
        ) {
            AddAnotherItemButton(
                style = AddAnotherItemButtonStyle.defaultTheme(LocalCustomColorsPaletteFlow)
            ) {}
            Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
            RoundedCornerFilledButton(
                text = "Test",
                customColors = LocalCustomColorsPaletteFlow,
            ){

            }
            Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
            RoundedCornerOutlinedButton(
                text = "Test",
                customColors = LocalCustomColorsPaletteFlow,
            ){

            }
            Spacer(modifier = Modifier.height(ConstantsValuesDp.value_dp_16))
            GradientButton(
                text = "Test",
            ){

            }
        }
    }
}