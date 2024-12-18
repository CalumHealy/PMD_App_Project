package com.example.aviatory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.ui.text.style.TextAlign

data class HomeScreenListItem(val id: String, val imageRes: Int, val description: String)

val homeScreenItemList = listOf(
    HomeScreenListItem("Boeing 737", R.drawable.b737img, "Boeing 737: Boeing's most popular aircraft. "),
    HomeScreenListItem("Airbus A320", R.drawable.a320img, "Airbus A320: Airbus's most popular aircraft. "),
    HomeScreenListItem("Boeing 747", R.drawable.b747img, "Boeing 747: Boeing's King of the air. This beauty has 1.5 floors. "),
    HomeScreenListItem("Airbus A380", R.drawable.a380img, "Airbus A380: Airbus's Queen of the air. This double decker is a big beast. "),
    HomeScreenListItem("Boeing 777X", R.drawable.b777ximg, "Boeing 777X: Boeing's most elegant and beautiful aircraft (in my opinion). "),
    HomeScreenListItem("Airbus A350", R.drawable.a350img, "Airbus A350: Airbus's widebody brute. "),
    HomeScreenListItem("CRJ1000", R.drawable.crj1000img, "CRJ1000: This slender beauty may look like it's about to crack in half, but it's fair sturdy. "),
    HomeScreenListItem("Global 5500", R.drawable.bg5500img, "Global 5500: This private jet from Bombardier is small but stunning, and can carry all your friends. "),
    HomeScreenListItem("Concorde", R.drawable.concordeimg, "Concorde: One of the most famous jets of all time, the Concorde blasted through the sky faster than sound!"),
    HomeScreenListItem("Airbus Beluga", R.drawable.belugaimg, "Airbus Beluga: The whale of the skies. ")
)

@Composable
fun HomeScreen(
    navController: NavController,
    favouritesViewModel: FavouritesViewModel,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize().
            background(Color(red = 175, green = 175, blue = 255)),
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 8.dp)
            ) {
                Text(
                    text = "AVIATORY",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center
                    ),
                    modifier = Modifier
                        .offset(1.dp, 1.dp)
                )

                Text (
                    text = "AVIATORY",
                    style = TextStyle(
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(red = 50, green = 0, blue = 150),
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Center
                    )
                )
            }

            AirlinesList(
                onItemClick = { itemId ->
                    navController.navigate(itemId)
                },
                favouritesViewModel = favouritesViewModel
            )
        }
    }
}

@Composable
fun AirlinesList(
    onItemClick: (id:String) -> Unit,
    favouritesViewModel: FavouritesViewModel
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(homeScreenItemList) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(red = 100, green = 150, blue = 255))
                    .clickable { onItemClick(item.id) }
                    .padding(2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = item.imageRes),
                            contentDescription = item.description,
                            // contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .size(140.dp)
                                .padding(end = 16.dp)
                                .aspectRatio(1.5f),
                            contentScale = ContentScale.Crop,
                        )
                        Text(
                            text = item.description,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = FontFamily.Serif,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                            )
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Icon(
                        imageVector = if (favouritesViewModel.isFavourite(item.id)) Icons.Filled.Favorite else Icons.Outlined.Favorite,
                        contentDescription = "Favourite Icon",
                        modifier = Modifier
                            .size(36.dp)
                            .align(Alignment.CenterHorizontally)
                            .clickable { favouritesViewModel.toggleFavourite(item.id) },
                        tint = if (favouritesViewModel.isFavourite(item.id)) Color.Red else Color(red = 80, green = 120, blue = 200)
                    )
                }
            }
        }
    }
}
