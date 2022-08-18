package learn.compose.example.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import learn.compose.example.util.Constants
import learn.compose.example.viewmodel.MainViewModel

@Composable
fun NavigationExample() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }, content = { padding ->
            NavHostContainer(navController = navController, padding = padding)
        }
    )
}

@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.padding(paddingValues = padding),
        builder = {

            // route: Home
            composable("home") {
                HomeScreen()
            }

            // route: profile
            composable("profile") {
                ProfileScreen()
            }

            // route: Counter
            composable("counter") {
                CounterScreen()
            }
        }
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    BottomNavigation(
        backgroundColor = Color.White,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        Constants.BottomNavItems.forEach { navItem ->
            BottomNavigationItem(
                selected = currentRoute == navItem.route,
                onClick = {
                    navController.navigate(navItem.route)
                },
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },
                label = {
                    Text(text = navItem.label)
                }
            )
        }
    }
}

@Preview
@Composable
private fun PreviewBottomNavigationBar() {
    val navController = rememberNavController()
    BottomNavigationBar(navController = navController)
}

@Preview
@Composable
private fun PreviewNavigationExample() {
    NavigationExample()
}