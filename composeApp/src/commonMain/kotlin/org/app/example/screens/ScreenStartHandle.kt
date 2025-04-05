package org.app.example.screens

import ScreenIconsComponent
import ScreenInputsComponent
import ScreenOthersComponent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Input
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Category
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import org.app.example.Screens
import org.app.example.components.LocalCustomColorsPalette
import org.app.example.components.LocalCustomColorsPaletteFlow
import org.app.example.components.bottomNavigationComponent.FlowNavigationBar
import org.app.example.components.bottomNavigationComponent.FlowNavigationItem
import org.app.example.navigation.ConfigurationMain
import org.app.example.navigation.MainScreenComponent
import org.app.example.screens.buttonsScreen.ScreenButtonComponent
import org.app.example.screens.buttonsScreen.ScreenButtons
import org.app.example.screens.iconsScreen.ScreenIcons
import org.app.example.screens.inputsScreen.ScreenInputs
import org.app.example.screens.screenOthers.ScreenOthers

@Composable
fun ScreenStartHandle(
    component: MainScreenComponent,
    buttonComponent: ScreenButtonComponent,
    iconsComponent: ScreenIconsComponent,
    inputsComponent: ScreenInputsComponent,
    othersComponent: ScreenOthersComponent
) {
    var currentScreen by remember { mutableStateOf("Home") }
    val currentConfiguration by component.getCurrentConfiguration().collectAsState()
    // Create navigation items
    val navItems = listOf(
        FlowNavigationItem(
            icon = Icons.Filled.Home,
            iconSelected = Icons.Outlined.Home,
            label = "Buttons",
            screen = Screens.START.name,
            screenComponent = ConfigurationMain.ScreenHome
        ), FlowNavigationItem(
            icon = Icons.Filled.List,
            iconSelected = Icons.Outlined.List,
            label = "Inputs",
            screen = Screens.INPUTS.name,
            iconSize = 24,
            screenComponent = ConfigurationMain.ScreenInputs
        ), FlowNavigationItem(
            icon = Icons.Filled.Category,
            iconSelected = Icons.Outlined.Category,
            label = "Icons",
            screen = Screens.ICONS.name,
            iconSize = 24,
            screenComponent = ConfigurationMain.ScreenIcons
        ), FlowNavigationItem(
            icon = Icons.Filled.Settings,
            iconSelected = Icons.Outlined.Settings,
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
        }) { innerPadding ->
        Box(
            modifier = Modifier.padding(
                top = innerPadding.calculateTopPadding()
            ).background(LocalCustomColorsPaletteFlow.current.surfacePrimary),
        ) {
            when (currentConfiguration) {
                ConfigurationMain.ScreenHome -> ScreenButtons(buttonComponent)
                ConfigurationMain.ScreenIcons -> ScreenIcons(iconsComponent)
                ConfigurationMain.ScreenInputs -> ScreenInputs(inputsComponent)
                ConfigurationMain.ScreenOthers -> ScreenOthers(othersComponent)
            }
        }

    }

}