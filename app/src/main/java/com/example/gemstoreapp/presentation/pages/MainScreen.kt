package com.example.gemstoreapp.presentation.pages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.gemstoreapp.presentation.models.NavItem
import com.example.gemstoreapp.presentation.navigation.NavGraph
import com.example.gemstoreapp.presentation.navigation.Route

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val navItems = listOf(
        NavItem("Home", Icons.Default.Home),
        NavItem("Favourites", Icons.Default.ShoppingCart),
        NavItem("Settings", Icons.Default.Settings)
    )
    var bottomBarState by remember{
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItems.forEachIndexed{index,navItem ->
                    NavigationBarItem(
                        selected = bottomBarState == index,
                        onClick = {
                            bottomBarState = index
                        },
                        icon = {
                            Icon(imageVector = navItem.icon, contentDescription = "Icon")
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        },
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),bottomBarState)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, bottomBarState: Int) {
    when(bottomBarState){
        0 -> NavGraph(startDestination = Route.HomeScreen.toString())
        1 -> NavGraph(startDestination = Route.FavouriteScreen.toString())
        2 -> NavGraph(startDestination = Route.SettingScreen.toString())
    }

}