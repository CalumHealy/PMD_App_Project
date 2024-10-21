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
import androidx.compose.material3.ListItem
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

data class ListItem(val id: String, val imageRes: Int, val description: String)

val itemList = listOf(
    ListItem("boeingScreen", R.drawable.image1, "Boeing"),
    ListItem("airbusScreen", R.drawable.image2, "Airbus"),
    ListItem("mitsubishiScreen", R.drawable.image3, "Mitsubishi")
)

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    var selectedItemId by remember { mutableStateOf<String>("Boeing") }

    Box(modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    )
    {
        Column {
            AirlinesList(onItemClick = {itemId ->
                selectedItemId = itemId
                navController.navigate(selectedItemId!!)
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
}

@Composable
fun AirlinesList(onItemClick: (id:String) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemList) { item ->
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