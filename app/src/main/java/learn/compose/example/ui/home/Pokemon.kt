package learn.compose.example.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.google.gson.reflect.TypeToken

data class Pokemon(
    @SerializedName("zukan_id")
    val index: String = "",
    @SerializedName("pokemon_name")
    val name: String = "",
    @SerializedName("file_name")
    val cover: String = "",
)

@Composable
fun PokemonScreen() {
    val json = LocalContext.current.assets.open("pokemon_list.json").bufferedReader().use { it.readText() }
    val pokemonList = Gson().fromJson<List<Pokemon>>(json, object : TypeToken<List<Pokemon>>() {}.type)
    LazyColumnExample(pokemonList)
}

@Composable
fun LazyColumnExample(pokemonList: List<Pokemon> = emptyList()) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(pokemonList) { pokemon ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                PokemonCard(pokemon)
            }
        }
    }
}

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val coverPath = "https://www.pokemon.cn/play/resources/pokedex/"
            Image(
                painter = rememberImagePainter("$coverPath${pokemon.cover}"),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Text(text = pokemon.name)
        }
    }
}