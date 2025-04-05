package org.app.example.screens.screenOthers

import ScreenOthersComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.kotlin.data.model.ConstantsValuesDp
import org.app.example.components.FlowUITheme
import org.app.example.components.LocalCustomColorsPaletteFlow

@Composable
fun ScreenOthers(component: ScreenOthersComponent) {
    FlowUITheme {
        Column(
            modifier = Modifier.background(LocalCustomColorsPaletteFlow.current.surfaceSecondary)
                .fillMaxSize()
                .padding(top = ConstantsValuesDp.value_dp_16)
        ) {
            Text("Others")
        }
    }
}