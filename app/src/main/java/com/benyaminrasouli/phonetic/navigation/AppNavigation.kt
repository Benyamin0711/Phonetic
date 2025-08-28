package com.benyaminrasouli.phonetic.navigation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.*
import com.benyaminrasouli.phonetic.ui.components.BottomNavBar
import com.benyaminrasouli.phonetic.ui.home.HomeScreen
import com.benyaminrasouli.phonetic.ui.kaypad.KaypadScreen
import com.benyaminrasouli.phonetic.ui.contacts.ContactScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost

sealed class Screen(val route: String, val label: String, val icon: String) {
    object Contact : Screen("contact", "Contact", "Contact")
    object Home : Screen("home", "Home", "Home")
    object Kaypad : Screen("kaypad", "Kaypad", "Dialpad")

}

val bottomNavScreens = listOf(
    Screen.Contact,
    Screen.Home,
    Screen.Kaypad
)

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    var currentRoute by remember { mutableStateOf(Screen.Home.route) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                screens = bottomNavScreens,
                currentRoute = currentRoute,
                onTabSelected = { route ->
                    if (route != currentRoute) {
                        navController.navigate(route) {
                            launchSingleTop = true
                            restoreState = true
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                        }
                        currentRoute = route
                    }
                }
            )
        }
    ) { innerPadding ->
        AnimatedNavHost(
            navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screen.Kaypad.route,
                enterTransition = { fadeIn() },
                exitTransition = { fadeOut() }) {
                KaypadScreen()
                currentRoute = Screen.Kaypad.route
            }
            composable(Screen.Home.route,
                enterTransition = { fadeIn() },
                exitTransition = { fadeOut() }) {
                HomeScreen()
                currentRoute = Screen.Home.route
            }
            composable(Screen.Contact.route,
                enterTransition = { fadeIn() },
                exitTransition = { fadeOut() }) {
                ContactScreen()
                currentRoute = Screen.Contact.route
            }
        }
    }
}