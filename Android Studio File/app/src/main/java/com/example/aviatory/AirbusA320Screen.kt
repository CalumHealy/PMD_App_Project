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

@Composable
fun AirbusA320Screen( modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize().background(Color.Green),
        contentAlignment = Alignment.Center
    ){
        Text(text="Airbus A320 Screen",
            fontSize = 36.sp,
            color = Color.Red)
    }
}