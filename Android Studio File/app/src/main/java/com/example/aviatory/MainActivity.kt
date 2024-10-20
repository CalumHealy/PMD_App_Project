package com.example.aviatory

// Default imports
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aviatory.ui.theme.AviatoryTheme

// My imports
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon

import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController


//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Search
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.outlined.Home
//import androidx.compose.material.icons.outlined.Search
//import androidx.compose.material.icons.outlined.Person
//import androidx.compose.material3.Badge
//import androidx.compose.material3.BadgedBox
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.NavigationBar
//import androidx.compose.material3.Icon
//import androidx.compose.material3.NavigationBarItem
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.ui.graphics.vector.ImageVector
//import androidx.navigation.NavController
//import androidx.navigation.NavHost

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AviatoryTheme {
                Scaffold { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color(red = 255, green = 170, blue = 220))
                            .padding(innerPadding)
                            .padding(top = 50.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            TitleText(title = "Aviatory")
                        }
                    }
                }
                ProfileScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3F2FD)), // Light Blue Background
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Home Screen", fontSize = 24.sp, color = Color.Black)
    }
}

@Composable
fun SearchScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFBBDEFB)), // Lighter Blue Background
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Search Screen", fontSize = 24.sp, color = Color.Black)
    }
}

@Composable
fun ProfileScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF90CAF9)), // Different Blue Background
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Profile Screen", fontSize = 24.sp, color = Color.Black)
    }
}

@Composable
fun TitleText(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color(red = 90, green = 130, blue = 255)
        )
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AviatoryTheme {
        Greeting("Android")
    }
}

// Generic menu function
@Composable
fun OptionsDropDownMenu(
    expanded: Boolean,
    onDismiss:() -> Unit,
    onOptionSelected: (String) -> Unit,
    options: List<String> // accepts a list of options for the menu as parameter
) {
    val context = LocalContext.current
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = {onDismiss()}
    ) {
        // iterate over the option list and create a dropdown menu item for each option
        options.forEach { option ->
            DropdownMenuItem(
                text = { Text(text = option)},
                onClick = {
                    onOptionSelected(option)
                    // Optional action
                    Toast.makeText(context, option, Toast.LENGTH_SHORT).show()
                    onDismiss()
                }
            )
        }
    }
}

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
                    var contextExpanded by remember { mutableStateOf(false)}
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