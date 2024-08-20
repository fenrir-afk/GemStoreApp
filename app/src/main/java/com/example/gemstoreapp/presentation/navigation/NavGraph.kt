package com.example.gemstoreapp.presentation.navigation



import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gemstoreapp.presentation.pages.FavouriteScreen
import com.example.gemstoreapp.presentation.pages.HomeScreen
import com.example.gemstoreapp.presentation.pages.SettingsScreen


@Composable
fun NavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Route.HomeScreen.route) {
            HomeScreen()
        }
        composable(route = Route.SettingScreen.route) {
            SettingsScreen()
        }
        composable(route = Route.FavouriteScreen.route) {
            FavouriteScreen()
        }
    }
}