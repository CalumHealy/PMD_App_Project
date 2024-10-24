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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.ui.window.Popup
import androidx.lifecycle.viewmodel.compose.viewModel

data class BoeingScreenListItem(val id: String, val imageRes: Int, val description: String)

val boeingScreenItemList = listOf(
    BoeingScreenListItem("B737-700", R.drawable.image1, "737-700"),
    BoeingScreenListItem("B777", R.drawable.image4, "777"),
    BoeingScreenListItem("B747", R.drawable.image5, "747")
)

@Composable
fun BoeingScreen(navController: NavController, modifier: Modifier = Modifier, FavouriteListViewModel: FavouriteListViewModel = viewModel()) {
    var selectedItemId by remember { mutableStateOf<String>("B737-700") }
    var showPopup by remember { mutableStateOf(false) }
    var lastClickedId by remember { mutableStateOf(String) }

    Box(modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    )/*{
        Text(text="Boeing Screen",
            fontSize = 36.sp,
            color = Color.Red)
    }*/
    {
        Column {
            BoeingPlanesList(onItemClick = {itemId ->
                // lastClickedId = itemId
                // showPopup(itemId)
                print(selectedItemId)
            })

            //selectedItemId?.let {
            if (selectedItemId != null) {
                Text(
                    text = "Selected Item ID: $selectedItemId",
                    color = Color.Black,
                    style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(16.dp)
                )
            }

//            AirlinesList(onItemClick = {itemId ->
//                selectedItemId = itemId
//            })
        }
    }
    if (showPopup) {
        Popup(alignment = Alignment.Center) {
            Box(
                modifier = Modifier
                    .size(300.dp)
                    .background(Color.White)
                    .padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Boeing 737-700: The soldier of the skies.")
                    Text(text = "The 737 is the standard aircraft for many airlines, used often for short-distance flights.")
                    Text(text = "As of October 2024, Boeing have produced 11,112 737's.")
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "Close",
                        modifier = Modifier
                            .clickable { showPopup = false }
                            .background(Color.Gray)
                            .padding(8.dp),
                        color = Color.White
                    )
                    if (FavouriteListViewModel.isInFavourites(selectedItemId)) {
                        Text(
                            text = "Remove from favourites",
                            modifier = Modifier
                                .clickable { FavouriteListViewModel.removeFavourite(selectedItemId)}
                                .background(Color.Gray)
                                .padding(8.dp),
                            color = Color.White
                        )
                    } else {
                        Text(
                            text = "Add to favourites",
                            modifier = Modifier
                                .clickable { FavouriteListViewModel.addFavourite(selectedItemId)}
                                .background(Color.Gray)
                                .padding(8.dp),
                            color = Color.White
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun BoeingPlanesList(onItemClick: (id:String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(boeingScreenItemList) { item ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Red)
                    .clickable { onItemClick(item.id) }
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    horizontalArrangement = Arrangement.Start,
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
                    Text (
                        text = item.description,
                        color = Color.Black,
                        style = TextStyle(
                            fontFamily = FontFamily.Serif,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                        ),
                        // modifier = Modifier.alignByBaseline()
                    )
                }
            }
        }
    }
}

@Composable
fun showPopup(itemId: String) {

}