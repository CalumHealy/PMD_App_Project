package com.example.aviatory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun CRJ1000Screen( onBackClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(red = 175, green = 175, blue = 255))
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = { onBackClick() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "CRJ1000",
                style = TextStyle(
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(red = 50, green = 0, blue = 150),
                    fontFamily = FontFamily.Serif
                )
            )

            Spacer(modifier = Modifier.weight(1.6f))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp)
                .padding(10.dp)
                .border(width = 4.dp, color = Color(red = 0, green = 0, blue = 0)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.crj1000img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .matchParentSize()
            )
        }

        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            val bulletPoints = listOf(
                "Introduced: 2009",
                "Total Made: 63",
                "Capacity: 104",
                "Length: 39m",
                "Wingspan: 26m",
                "Distance: 1,490nmi",
                "Largest Fleet: Air Nostrum (29)"
            )
            bulletPoints.forEach { point ->
                Row(
                    modifier = Modifier.padding(vertical = 4.dp)
                ) {Text(
                    text = "\u2022",
                    style = TextStyle(fontSize = 16.sp),
                    // color = MaterialTheme.colorScheme.primary,
                    color = Color(red = 50, green = 0, blue = 150),
                    modifier = Modifier.padding(end = 8.dp)
                )
                    Text(
                        text = point,
                        style = TextStyle(fontSize = 16.sp, color = Color.Black),
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}