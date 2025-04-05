package io.github.kotlin.components.keyboardDismissWrapper

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@Composable
fun KeyboardDismissWrapper(content: @Composable () -> Unit) {
    val keyboardController = LocalSoftwareKeyboardController.current

    // Modifier to detect taps outside the input field
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                onClick = {
                    keyboardController?.hide() // Hide the keyboard on tap
                },
                indication = null, // Remove ripple effect
                interactionSource = remember { MutableInteractionSource() }
            )
    ) {
        content()
    }
}