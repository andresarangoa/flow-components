package org.app.example.navigation


import ScreenIconsComponent
import ScreenInputsComponent
import ScreenOthersComponent
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.bringToFront
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import kotlinx.serialization.Serializable
import org.app.example.screens.buttonsScreen.ScreenButtonComponent

class RootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext {

    private var navigation = StackNavigation<Configuration>()
    private val initialScreen: Configuration = Configuration.ScreenStart

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = initialScreen,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun resetStackTo() {
        navigation.replaceAll(Configuration.ScreenStart)
    }

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration, context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.ScreenStart -> Child.ScreenStart(
                MainScreenComponent(
                    componentContext = context
                ),
                ScreenButtonComponent(
                    componentContext = context
                ),
                ScreenInputsComponent(
                    componentContext = context
                ),
                ScreenIconsComponent(
                    componentContext = context
                ),
                ScreenOthersComponent(
                    componentContext = context
                )
            )
        }

    }

    sealed class Child {
        data class ScreenStart(
            val component: MainScreenComponent,
            val buttonComponent: ScreenButtonComponent,
            val inputsComponent: ScreenInputsComponent,
            val iconsComponent: ScreenIconsComponent,
            val othersComponent: ScreenOthersComponent
        ) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object ScreenStart : Configuration()

    }
}