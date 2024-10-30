package com.example.aviatory

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape

@Composable
fun FavouritesScreen(
    favouritesViewModel: FavouritesViewModel,
    onItemClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val favouriteItems = homeScreenItemList.filter { favouritesViewModel.isFavourite(it.id) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(red = 175, green = 175, blue = 255)),
        contentAlignment = Alignment.Center
    ) {
        if (favouriteItems.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "No favourites yet!",
                        color = Color.Black,
                        style = TextStyle(
                            fontWeight = Bold,
                            fontSize = 22.sp
                        ),
                        modifier = Modifier
                            .padding(8.dp)
                    )
                    Box(
                        modifier = Modifier
                            .size(300.dp)
                            .padding(end = 16.dp)
                            .aspectRatio(1.5f)
                            .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0))
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.nofavouritesimg),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.matchParentSize()
                        )
                    }
                }
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                //items(homeScreenItemList) { item ->
                items(favouriteItems) { item ->
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
    }
}