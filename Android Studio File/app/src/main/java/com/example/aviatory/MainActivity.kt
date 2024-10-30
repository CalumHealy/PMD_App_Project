package com.example.aviatory

// Default imports
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aviatory.ui.theme.AviatoryTheme

// My imports
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone

import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Favourites : Screen("favourites")
    object HistoryScreen : Screen("history")
    object LiveATC : Screen("liveATC")
    object Boeing737Screen : Screen("Boeing 737")
    object AirbusA320Screen : Screen("Airbus A320")
    object Boeing747Screen : Screen("Boeing 747")
    object AirbusA380Screen : Screen("Airbus A380")
    object Boeing777XScreen : Screen("Boeing 777X")
    object AirbusA350Screen : Screen("Airbus A350")
    object CRJ1000Screen : Screen("CRJ1000")
    object Global5500Screen : Screen("Global 5500")
    object ConcordeScreen : Screen("Concorde")
    object AirbusBelugaScreen : Screen("Airbus Beluga")
}

data class NavItem(
    var label: String,
    val icon: ImageVector,
    val screen: Screen
)



class MainActivity : ComponentActivity() {
    private val favouritesViewModel: FavouritesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AviatoryTheme {
                val navController = rememberNavController()
                val navItemList = listOf(
                    NavItem(label = "Home", icon = Icons.Default.Home, screen = Screen.Home),
                    NavItem(label = "Favourites", icon = Icons.Default.Favorite, screen = Screen.Favourites),
                    NavItem(label = "History", icon = Icons.Default.Info, screen = Screen.HistoryScreen),
                    NavItem(label = "LiveATC", icon = Icons.Default.Phone, screen = Screen.LiveATC)
                )
                var selectedIndex by rememberSaveable { mutableStateOf(0) }

                Scaffold (
                   modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomAppBar {
                            NavigationBar {
                                navItemList.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedIndex == index,
                                        onClick = {
                                            selectedIndex = index
                                            if(navController.currentDestination?.route!=item.screen.route) {
                                                navController.navigate(item.screen.route) {
                                                    launchSingleTop = true // Avoid multiple copies of the same destination
                                                    restoreState = true // Restore previous state when navigating back
                                                }
                                            }
                                        },
                                        icon = {
                                            Icon(
                                                imageVector = item.icon,
                                                contentDescription = item.label
                                            )
                                        },
                                        label = { Text(text = item.label) }
                                    )
                                }
                            }
                        }
                    }
                ) {
                    innerPadding ->
                    // Set up the navigation graph
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(Screen.Home.route) { HomeScreen(navController, favouritesViewModel) }
                        composable(Screen.Favourites.route) { FavouritesScreen(
                            favouritesViewModel = favouritesViewModel,
                            onItemClick = { itemId ->
                                navController.navigate(itemId)
                            }
                        ) }
                        composable(Screen.LiveATC.route) { LiveATC() }
                        composable(Screen.HistoryScreen.route) { HistoryScreen() }
                        composable(Screen.Boeing737Screen.route) { Boeing737Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.AirbusA320Screen.route) { AirbusA320Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.Boeing747Screen.route) { Boeing747Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.AirbusA380Screen.route) { AirbusA380Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.Boeing777XScreen.route) { Boeing777XScreen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.AirbusA350Screen.route) { AirbusA350Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.CRJ1000Screen.route) { CRJ1000Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.Global5500Screen.route) { Global5500Screen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.ConcordeScreen.route) { ConcordeScreen(onBackClick = { navController.popBackStack() }) }
                        composable(Screen.AirbusBelugaScreen.route) { AirbusBelugaScreen(onBackClick = { navController.popBackStack() }) }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AviatoryTheme {
        Greeting("Android")
    }
}
