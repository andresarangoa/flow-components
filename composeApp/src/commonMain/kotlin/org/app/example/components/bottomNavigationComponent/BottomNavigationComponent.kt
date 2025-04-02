package org.app.example.components.bottomNavigationComponent

import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.app.example.navigation.ConfigurationMain
import org.app.example.navigation.MainScreenComponent
import org.jetbrains.compose.resources.painterResource

/**
 * A navigation item for FlowNavigationBar
 * @param icon Resource ID for the icon
 * @param label Text to display under the icon
 * @param screen Screen identifier for this navigation item
 */
data class FlowNavigationItem(
    val icon: ImageVector,
    val iconSelected: ImageVector,
    val label: String,
    val screen: String,
    val screenComponent: ConfigurationMain,
    val iconSize: Int = 24 // Default icon size
)

/**
 * FlowNavigationBar - A customizable bottom navigation bar for Kotlin Multiplatform
 *
 * @param currentScreen The currently selected screen identifier
 * @param items List of navigation items to display
 * @param onNavigationSelected Callback when a navigation item is selected
 * @param containerColor Background color of the navigation bar
 * @param contentColor Default color for content (text, icons)
 * @param selectedItemColor Color for the selected item icon
 * @param selectedTextColor Color for the selected item text
 * @param unselectedItemColor Color for unselected item icons and text
 * @param indicatorColor Color for the selection indicator
 */
@Composable
fun FlowNavigationBar(
    currentScreen: String,
    items: List<FlowNavigationItem>,
    onNavigationSelected: (String, ConfigurationMain) -> Unit,
    containerColor: Color = Color(0xFF1F1F1F),
    contentColor: Color = Color.White,
    selectedItemColor: Color = Color(0xFF6200EE),
    selectedTextColor: Color = Color.White,
    unselectedItemColor: Color = Color.Gray,
    indicatorColor: Color = Color(0xFF3700B3)
) {
    BottomAppBar(
        containerColor = containerColor,
        contentColor = contentColor
    ) {
        items.forEach { item ->
            val isSelected = currentScreen == item.screen

            NavigationBarItem(
                icon = {
                    Icon(
                        imageVector = item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.size(item.iconSize.dp),
                        tint = if (isSelected) selectedItemColor else unselectedItemColor
                    )
                },
                label = {
                    Text(
                        text = item.label,
                        color = if (isSelected) selectedTextColor else unselectedItemColor
                    )
                },
                selected = isSelected,
                onClick = { onNavigationSelected(item.screen, item.screenComponent) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = selectedItemColor,
                    selectedTextColor = selectedTextColor,
                    unselectedIconColor = unselectedItemColor,
                    unselectedTextColor = unselectedItemColor,
                    indicatorColor = indicatorColor
                )
            )
        }
    }
}