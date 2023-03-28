package com.example.learnjetpackcompose

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrossfadeBootacmpComposbale() {

    var showSecondaryBottomBar by remember {
        mutableStateOf(false)
    }

    Crossfade(targetState = showSecondaryBottomBar) { show ->
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    showSecondaryBottomBar =
                        showSecondaryBottomBar.not()
                }) {
                    Icon(Icons.Filled.Add, "Add Button")
                }
            },
            bottomBar = {
                if (show) {
                    SecondaryBottomBar()
                } else {
                    PrimaryBottomBar()
                }
            }
        )
        { paddingValue ->
            Column(
                modifier = Modifier.padding(paddingValue)
            ) {

            }
        }
    }
}

@Composable
fun PrimaryBottomBar() {
    BottomAppBar(
        contentColor = Color.Black,
        containerColor = Color(
            red = 0xF0, green = 0xED, blue =
            0xDF
        ),

        ) {
        IconButton(onClick = { /* Check onClick */ }) {
            Icon(
                Icons.Filled.Check,
                contentDescription = ""
            )
        }
        IconButton(onClick = { /* Edit onClick */ }) {
            Icon(
                Icons.Filled.Edit, contentDescription
                = ""
            )
        }
        IconButton(onClick = { /* Delete onClick */ }) {
            Icon(
                Icons.Filled.Delete,
                contentDescription = ""
            )
        }
    }
}

@Composable
fun SecondaryBottomBar() {
    BottomAppBar(
        contentColor = Color.Black,
        containerColor = Color(
            red = 0xF0, green = 0xED, blue =
            0xDF
        ),

        ) {
        IconButton(onClick = { /* Check onClick */ }) {
            Icon(
                Icons.Filled.Send,
                contentDescription = ""
            )
        }
        IconButton(onClick = { /* Edit onClick */ }) {
            Icon(
                Icons.Filled.Email, contentDescription
                = ""
            )
        }
        IconButton(onClick = { /* Delete onClick */ }) {
            Icon(
                Icons.Filled.Favorite,
                contentDescription = ""
            )
        }
    }
}



@Preview(device = Devices.PIXEL, showSystemUi = true)
@Composable
fun CrossfadeBootcampPreview() {
    CrossfadeBootacmpComposbale()
}

/*
Crossfade is used to animate the transition between two
composables by gradually fading one out while fading the other
in. It takes two parameters: the first is the content
of the "from" composable, and the second
is the content of the "to" composable.
 */