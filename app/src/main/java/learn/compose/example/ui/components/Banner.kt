package learn.compose.example.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.delay

data class Banner(
    val imageUrl: String = "",
    // val url: String =""
)

val banners = arrayListOf(
    Banner("https://www-static.chinacdn.starbucks.com.cn/prod/images/pages/tmall-2020-06-29-zh.jpg"),
    Banner("https://artwork.starbucks.com.cn/banners-homepage-banner/main_61babe13-d569-476b-8bd6-e75068943318.jpg"),
    Banner("https://www.starbucks.com.tw/home/objects/images/211129/banner_mobile-order-pay@0.5x.png")
)

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerExample() {
    val pagerState = rememberPagerState()
    BannerPager(banners, pagerState)
    LaunchedEffect(pagerState.currentPage) {
        if (pagerState.pageCount > 0) {
            delay(3000L)
            pagerState.animateScrollToPage((pagerState.currentPage + 1) % pagerState.pageCount)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun BannerPager(banners: List<Banner> = emptyList(), pagerState: PagerState = rememberPagerState()) {
    Column(Modifier.fillMaxWidth()) {
        HorizontalPager(
            count = banners.size,
            state = pagerState
        ) { page: Int ->
            BannerCard(banner = banners[page]) {
            }
        }
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp),
        )
    }
}

@Composable
fun BannerCard(banner: Banner, onBannerClick:() -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = rememberImagePainter(data = banner.imageUrl),
            contentDescription = null,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
private fun PreviewBannerExample() {
    BannerExample()
}