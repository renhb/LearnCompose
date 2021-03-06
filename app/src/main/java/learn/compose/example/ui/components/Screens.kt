package learn.compose.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import learn.compose.example.ui.home.PokemonScreen
import learn.compose.example.ui.theme.Purple700
import learn.compose.example.viewmodel.MainViewModel

@Composable
fun HomeScreen() {
    // Column(
    //     modifier = Modifier
    //         .fillMaxSize()
    //         .background(Color.White),
    //     horizontalAlignment = Alignment.CenterHorizontally,
    //     verticalArrangement = Arrangement.Center
    // ) {
    //     Icon(
    //         imageVector = Icons.Default.Home,
    //         contentDescription = "home",
    //         tint = Purple700
    //     )
    //     Text(text = "Home", color = Color.Black)
    // }
    PokemonScreen()
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        // parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Icon(
        //     imageVector = Icons.Default.Person,
        //     contentDescription = "Profile",
        //     tint = Purple700
        // )
        // Text(text = "Profile", color = Color.Black)
        BannerExample()
    }
}

@Composable
fun CounterScreen(viewModel: MainViewModel) {
    val count by viewModel.counterLiveData.observeAsState(0)
    val text = "This is $count"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        BasicText(text)
        Button(
            onClick = {
                viewModel.increaseCounter()
            },
        ) {
            BasicText(text = "Add 1")
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen()
}