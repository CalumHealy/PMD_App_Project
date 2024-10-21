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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

data class ListItem(val imageRes: Int, val description: String)

val itemList = listOf(
    ListItem(R.drawable.image1, "Item 1 Description"),
    ListItem(R.drawable.image2, "Item 2 Description"),
    ListItem(R.drawable.image3, "Item 3 Description")
)

@Composable
fun HomeScreen( modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.Center
    )
    {
        AirlinesList()
    }
}

@Composable
fun AirlinesList() {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemList) { item ->
            Row(
                modifier = Modifier.fillMaxWidth().padding(8.dp),
                horizontalArrangement = Arrangement.Start
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
                    modifier = Modifier.alignByBaseline()
                )
            }
        }
    }
}