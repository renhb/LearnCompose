package learn.compose.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
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
fun CounterScreen() {
    var count by remember { mutableStateOf(0) }
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
                count++
            },
            modifier = Modifier.semantics { contentDescription = "Add to favorites" }
        ) {
            BasicText(text = "Add 1")
        }
        Button(
            onClick = {
                count++
            },
            modifier = Modifier.semantics { contentDescription = "Add to favorites" }
        ) {
            BasicText(text = "Add 1")
        }
        Button(
            onClick = {
                count++
            },
            modifier = Modifier.semantics { contentDescription = "Add to favorites" }
        ) {
            BasicText(text = "Add 1")
        }
    }
}


@Preview
@Composable
fun PreviewHomeScreen() {
    CounterScreen()
}




@Composable
fun Counter() {
    var count by remember { mutableStateOf(0) }
    Column {
        Button(modifier = Modifier.padding(16.dp),onClick = { count++ })
        {
            Text("Add 1")
        }
        Text(text = "This is $count")
    }
}

data class CounterState(
    val count: Int = 0
) : MavericksState

class CounterViewModel(initialState: CounterState) :
    MavericksViewModel<CounterState>(initialState) {
    fun incrementCount() = setState { copy(count = count + 1) }
}

@Composable
fun IncrementCountComponent() {
    val viewModel: CounterViewModel = mavericksViewModel()
    Button(onClick = { viewModel.incrementCount() }) {
        Text("Increment Count")
    }
    val count by viewModel.collectAsState { it.count }
    IncrementCountComponent(count)
}

@Composable
fun IncrementCountComponent(count: Int) {
    Text("Count is $count")
}