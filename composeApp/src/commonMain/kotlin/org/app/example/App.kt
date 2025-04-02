package org.app.example

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import org.app.example.navigation.RootComponent
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import multiplatform_library_template.composeapp.generated.resources.Res
import org.app.example.components.FlowTheme
import org.app.example.components.LocalCustomColorsPalette
import org.app.example.components.bottomNavigationComponent.FlowNavigationBar
import org.app.example.components.bottomNavigationComponent.FlowNavigationItem
import org.app.example.screens.ScreenStartHandle
import org.app.example.screens.buttonsScreen.ScreenButtons
import org.app.example.screens.iconsScreen.ScreenIcons
import org.app.example.screens.inputsScreen.ScreenInputs
import org.app.example.screens.screenOthers.ScreenOthers

@Composable
@Preview
fun App(root: RootComponent) {
    KoinContext {
        appContent(root)
    }
}

enum class Screens {
    START,
    INPUTS,
    ICONS,
    OTHERS
}

@Composable
@Preview
fun appContent(root: RootComponent) {

    var currentScreen by remember { mutableStateOf(Screens.START.name) }

    val childStack by root.childStack.subscribeAsState()
    Children(
        stack = childStack,
        animation = stackAnimation(slide())
    ) { child ->
        FlowTheme {
                when (val instance = child.instance) {
                    is RootComponent.Child.ScreenStart -> ScreenStartHandle(instance.component)
                }
        }
    }
}