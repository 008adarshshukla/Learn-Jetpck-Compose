package com.example.learnjetpackcompose

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview



@OptIn(ExperimentalAnimationApi::class,
    ExperimentalMaterial3Api::class
)
@Composable
fun BottomAppBarComposable() {

    var showBottomBar by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    contentColor = Color.Black,
                    containerColor = Color(red = 0xF0, green = 0xED, blue =
                    0xDF)
                ) {
                    IconButton(onClick = { /* Check onClick */ }) {
                        Icon(Icons.Filled.Check,
                            contentDescription = "", tint = Color
                                .Black)
                    }
                    IconButton(onClick = { /* Edit onClick */ }) {
                        Icon(
                            Icons.Filled.Edit, contentDescription
                            = "", tint = Color.Black)
                    }
                    IconButton(onClick = { /* Delete onClick */ }) {
                        Icon(Icons.Filled.Delete,
                            contentDescription = "", tint = Color
                                .Black,)
                    }
                }
            }

        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                println(showBottomBar)
                showBottomBar = showBottomBar.not()
                println(showBottomBar)
            }) {
                Icon(Icons.Filled.Add, "Add Button")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) { value ->
        Column(modifier = Modifier.padding(value)) {
            
        }
    }
}

@Preview@Preview(device = Devices.PIXEL, showSystemUi = true)
@Composable
fun BottomAppBarPreview() {
    BottomAppBarComposable()
}

/*
starting from Jetpack Compose version 1.2.0, the padding
parameter is required in the Scaffold component's content
composable. The padding parameter is used to specify the
padding for the entire screen including the app bar and the
body content area.

To use the padding parameter in the Scaffold component, you
need to pass it to the content composable of the Scaffold
component. You should apply it to the topmost container/view
in content. Here's an example of how to use the padding
parameter in the Scaffold component:


 */