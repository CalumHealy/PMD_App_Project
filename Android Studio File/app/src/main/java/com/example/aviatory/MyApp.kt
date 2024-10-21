package com.example.aviatory

import android.widget.Toast
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    var expanded by remember {
        mutableStateOf(false)
    }
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "My App")
                },
                actions={
                    Button(onClick = {expanded = true}) {
                        Text(text="options")

                        // Icon(imageVector = Icons.Default.Menu, contextDescription = "Menu")
                    }
                    OptionsDropDownMenu(
                        expanded = expanded,
                        onDismiss = {expanded = false},
                        options = listOf("Option 1", "Option 2", "Option 3"),
                        onOptionSelected = {selectedOption ->
                            Toast.makeText(context, selectedOption, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            )
        },

        content = {innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center){

                Column() {
                    var popupExpanded by remember { mutableStateOf(false) }
                    Button(onClick = {popupExpanded = true}){
                        Text(text = "Show Popup Menu")
                    }
                    OptionsDropDownMenu(
                        expanded = popupExpanded,
                        onDismiss = {popupExpanded = false},
                        options = listOf("Pop up Option 1", "Pop up Option 2"),
                        onOptionSelected = {selectedOption ->
                            Toast.makeText(context, selectedOption, Toast.LENGTH_SHORT).show()
                        }
                    )
                    // Context menu on a text
                    var contextExpanded by remember { mutableStateOf(false) }
                    Text(
                        text = "Context Menu",
                        modifier = Modifier.pointerInput(Unit) {
                            detectTapGestures(
                                onLongPress = {
                                    contextExpanded = true
                                }
                            )
                        }
                    )
                    OptionsDropDownMenu(
                        expanded = contextExpanded,
                        onDismiss = {contextExpanded = false},
                        options = listOf("Context Option 1", "Context Option 2"),
                        onOptionSelected = {selectedOption ->
                            Toast.makeText(context, selectedOption, Toast.LENGTH_SHORT).show()
                        }
                    )
                }
            }
        }
    )
}