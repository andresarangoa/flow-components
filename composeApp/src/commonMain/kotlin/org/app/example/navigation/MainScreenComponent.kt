package org.app.example.navigation

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.serialization.Serializable

class MainScreenComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext, BaseViewModel() {
    private val navigation = MutableStateFlow<ConfigurationMain>(ConfigurationMain.ScreenHome)

    // Switch between different configurations
    fun navigateTo(configuration: ConfigurationMain) {
        navigation.value = configuration
    }
    // Get current navigation state
    fun getCurrentConfiguration(): StateFlow<ConfigurationMain> = navigation
    fun onEvent(event: ScreenHomeEvents) {
        when (event) {
            ScreenHomeEvents.ClickButtonLogout -> {
                launchWithCatchingException {
                }
            }
        }
    }
}

@Serializable
sealed class ConfigurationMain {
    @Serializable
    data object ScreenHome : ConfigurationMain()

    @Serializable
    data object ScreenInputs : ConfigurationMain()

    @Serializable
    data object ScreenIcons : ConfigurationMain()

    @Serializable
    data object ScreenOthers : ConfigurationMain()
}