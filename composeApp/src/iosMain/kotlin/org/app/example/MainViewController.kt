package org.app.example

import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import org.koin.core.context.startKoin
import org.app.controlbill.navigation.RootComponent

fun MainViewController() = ComposeUIViewController {
    val root =
        remember { RootComponent(DefaultComponentContext(LifecycleRegistry())) }

    App(root)
}
fun initKoin() {
    startKoin {
    }
}
