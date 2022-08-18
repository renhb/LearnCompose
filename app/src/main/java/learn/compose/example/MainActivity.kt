package learn.compose.example

import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import dagger.hilt.android.AndroidEntryPoint
import learn.compose.example.ui.components.NavigationExample

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //            NavigationExample()
            Column {
                DramaCover()
                CvCard()
                BuyButton()
            }
        }
    }
}


@Composable
fun DramaCover() {
    Box(Modifier.padding(20.dp), contentAlignment = Alignment.BottomEnd) {
        Image(
            painterResource(id = R.drawable.nft),
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(135.dp)
                .height(180.dp)
                .clip(
                    RoundedCornerShape(10.dp)
                )
                .border(
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(width = 2.dp, color = Color(0xFFFFC118))
                )
        )
        Image(
            painterResource(id = R.drawable.ic_drama_lock), contentDescription = null
        )
    }
}

@Composable

fun CvCard() {
    Column(modifier = Modifier.padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(id = R.drawable.nft),
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Text(
            text = "路知行",
            color = Color(0xFF1a1a1a),
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = "饰 魏无羡",
            color = Color(0xFF757575),
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 12.sp
        )
        Text(
            text = "(一二三四五六…)",
            color = Color(0xFFbdbdbd),
            modifier = Modifier.padding(top = 5.dp),
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun BuyButton() {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(45.dp)
            .background(
                shape = RoundedCornerShape(22.5f.dp),
                brush = Brush.horizontalGradient(
                    colors = listOf(Color(0XFFFFD53C), Color(0XFFFFC218))
                )
            )
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Image(
            painterResource(id = R.drawable.mpoint),
            contentDescription = "",
            modifier = Modifier.size(20.dp)
        )
        Text(
            text = "1000 Mポイントで有料ブロック解除",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.padding(start = 5.dp)
        )
    }
}

@Composable
fun Card() { // Width height
    val list = listOf(0, 1, 2)
    Box(
        Modifier
            .padding(8.dp)
            .background(Color.Gray, shape = RoundedCornerShape(6.dp))
            .padding(8.dp)
    ) { // Bitmap Vector
        // ImageBitmap ImageVector
        Image(
            painterResource(id = R.drawable.nft), contentDescription = null, Modifier.clip(
                CircleShape
            )
        ) // elevation
        Text(
            "Compose",
            Modifier
                .background(Color.White)
                .padding(8.dp), fontSize = 10.sp
        )
        Text(
            "Compose",
            Modifier
                .background(Color.White)
                .padding(8.dp), fontSize = 10.sp
        )
        Text(
            "Compose",
            Modifier
                .background(Color.White)
                .padding(8.dp), fontSize = 10.sp
        )

        // https://github.com/coil-kt/coil
        //        AsyncImage(
        //            model = "https://static.maoercdn.com/dramacoversmini/201805/20/03f12d413b10cdee7e9f9a781480ba83171253.jpg",
        //            contentDescription = null
        //        )
    }
}

@Preview
@Composable
fun PreViewCard() {
    Card()
}


//            Surface(color = Color.White) {
//                // Scaffold
//                // ScaffoldExample()
//
//                // Navigation
//                // NavigationExample()
//
//                // ViewModel
//                 val mainViewModel : MainViewModel by viewModels()
//                CounterScreen()
//            }