package learn.compose.example.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Timer
import learn.compose.example.model.BottomNavItem

object Constants {

    val BottomNavItems = listOf(
        BottomNavItem(
            label = "Home",
            icon = Icons.Filled.Home,
            route = "home"
        ),

        BottomNavItem(
            label = "Profile",
            icon = Icons.Filled.Person,
            route = "profile"
        ),

        BottomNavItem(
            label = "Counter",
            icon = Icons.Filled.Timer,
            route = "counter"
        )
    )
}