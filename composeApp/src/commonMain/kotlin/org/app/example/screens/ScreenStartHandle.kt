package org.app.example.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import org.app.example.Screens
import org.app.example.components.LocalCustomColorsPalette
import org.app.example.components.bottomNavigationComponent.FlowNavigationBar
import org.app.example.components.bottomNavigationComponent.FlowNavigationItem
import org.app.example.navigation.ConfigurationMain
import org.app.example.navigation.MainScreenComponent

@Composable
fun ScreenStartHandle(component: MainScreenComponent) {
    var currentScreen by remember { mutableStateOf("Home") }
    val currentConfiguration by component.getCurrentConfiguration().collectAsState()
    // Create navigation items
    val navItems = listOf(
        FlowNavigationItem(
            icon = Icons.Filled.Home,
            iconSelected = Icons.Filled.Home,
            label = "Buttons",
            screen = Screens.START.name,
            screenComponent = ConfigurationMain.ScreenHome
        ),
        FlowNavigationItem(
            icon = Icons.Filled.Home,
            iconSelected = Icons.Filled.Home,
            label = "Inputs",
            screen = Screens.INPUTS.name,
            iconSize = 24,
            screenComponent = ConfigurationMain.ScreenInputs
        ),
        FlowNavigationItem(
            icon = Icons.Filled.Home,
            iconSelected = Icons.Filled.Home,
            label = "Icons",
            screen = Screens.ICONS.name,
            iconSize = 24,
            screenComponent = ConfigurationMain.ScreenIcons
        ),
        FlowNavigationItem(
            icon = Icons.Filled.Home,
            iconSelected = Icons.Filled.Home,
            label = "Others",
            screen = Screens.OTHERS.name,
            screenComponent = ConfigurationMain.ScreenOthers
        )
    )

    Scaffold(
        bottomBar = {
            FlowNavigationBar(
                currentScreen = currentScreen,
                items = navItems,
                onNavigationSelected = { screen, screenComponent ->
                    currentScreen = screen
                    component.navigateTo(screenComponent)
                },
                containerColor = LocalCustomColorsPalette.current.surfaceOptionalNavbar,
                contentColor = LocalCustomColorsPalette.current.textBottomBanner,
                selectedItemColor = LocalCustomColorsPalette.current.textQuaternaryButton,
                selectedTextColor = LocalCustomColorsPalette.current.textBottomBanner,
                unselectedItemColor = LocalCustomColorsPalette.current.textBottomBanner,
                indicatorColor = LocalCustomColorsPalette.current.surfaceOnTabBarBottom
            )
        }
    ) {innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            currentScreen = when (currentConfiguration) {
                ConfigurationMain.ScreenHome -> "Buttons"
                ConfigurationMain.ScreenIcons -> "Icons"
                ConfigurationMain.ScreenInputs -> "Inputs"
                ConfigurationMain.ScreenOthers -> "Others"
            }
            when(currentConfiguration){
                ConfigurationMain.ScreenHome -> component.navigateTo(
                    configuration = ConfigurationMain.ScreenHome
                )
                ConfigurationMain.ScreenIcons -> component.navigateTo(
                    configuration = ConfigurationMain.ScreenIcons
                )
                ConfigurationMain.ScreenInputs -> component.navigateTo(
                    configuration = ConfigurationMain.ScreenInputs
                )
                ConfigurationMain.ScreenOthers -> component.navigateTo(
                    configuration = ConfigurationMain.ScreenOthers
                )
            }
        }

    }

}