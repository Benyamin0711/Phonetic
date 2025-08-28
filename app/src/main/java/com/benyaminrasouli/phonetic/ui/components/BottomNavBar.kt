package com.benyaminrasouli.phonetic.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import com.benyaminrasouli.phonetic.navigation.Screen

@Composable
fun BottomNavBar(
    screens: List<Screen>,
    currentRoute: String,
    onTabSelected: (String) -> Unit
) {
    NavigationBar(modifier = Modifier.fillMaxWidth()) {
        screens.forEach { screen ->
            val icon = when (screen.icon) {
                "Contact" -> Icons.Default.Contacts
                "Home" -> Icons.Default.Home
                "Dialpad" -> Icons.Default.Dialpad
                else -> Icons.Default.Home
            }
            NavigationBarItem(
                selected = currentRoute == screen.route,
                onClick = { onTabSelected(screen.route) },
                icon = {
                    Icon(
                        icon,
                        contentDescription = screen.label
                    )
                },
                label = { Text(screen.label) },
                alwaysShowLabel = true
            )
        }
    }
}