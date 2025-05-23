package com.example.multipageapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.multipageapp.ui.DashboardScreen
import com.example.multipageapp.ui.HomeScreen
import com.example.multipageapp.ui.NotificationsScreen
import com.example.multipageapp.ui.theme.MultiPageAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MultiPageAppTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomNavigationBar(navController) }
                ) { innerPadding ->
                    NavigationGraph(navController, Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf("home", "dashboard", "notifications")
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                label = { Text(screen.replaceFirstChar { it.uppercase() }) },
                selected = navController.currentDestination?.route == screen,
                onClick = { navController.navigate(screen) },
                icon = {}
            )
        }
    }
}

@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(navController, startDestination = "home", modifier = modifier) {
        composable("home") { HomeScreen() }
        composable("dashboard") { DashboardScreen() }
        composable("notifications") { NotificationsScreen() }
    }
}
