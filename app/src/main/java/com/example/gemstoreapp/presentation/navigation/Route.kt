package com.example.gemstoreapp.presentation.navigation

import androidx.navigation.NamedNavArgument

sealed class Route(
    val route: String,
    val arguments: List<NamedNavArgument> = emptyList()
) {

    data object HomeScreen : Route(route = "homeScreen")

    data object FavouriteScreen : Route(route = "favouriteScreen")

    data object SettingScreen : Route(route = "settingScreen")

}

