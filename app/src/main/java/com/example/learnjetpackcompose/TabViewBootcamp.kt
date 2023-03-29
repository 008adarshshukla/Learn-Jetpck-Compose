package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TabViewBootcampComposable() {
    Scaffold(
        topBar = {
            SmallTopAppBar(navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Default
                            .ArrowBack,
                        contentDescription = "Back" +
                                " Button"
                    )
                }
            },
                title = {
                    Text(text = "Top Bar")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Share,
                            contentDescription = "Share Button"
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = "Search Button"
                        )
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Menu Button"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            var selectedTabIndex by remember {
                mutableStateOf(1)
            }
            TabsComposable(
                selectedTabIndex = selectedTabIndex,
                updateSelectedTabIndex = { index ->
                    selectedTabIndex = index
                }
            )

            if (selectedTabIndex == 0) {
                Text(text = "Movies")
            }
            if (selectedTabIndex == 1) {
                Text(text = "Theatres")
            }
            if (selectedTabIndex == 2) {
                Text(text = "Showtimes")
            }
        }
    }
}


@Composable
fun TabsComposable(selectedTabIndex: Int,
                   updateSelectedTabIndex: (index: Int) ->
                   Unit) {
    TabRow(selectedTabIndex = selectedTabIndex,
        containerColor = Color.White,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier
                    .tabIndicatorOffset
                        (tabPositions[selectedTabIndex]),
                height = 2.dp,
                color = Color.Green
            )
        }
    ) {
        Tab(selected = selectedTabIndex == 0, onClick = {
            updateSelectedTabIndex(0)
        }) {
            Text(text = "Movies")
        }

        Tab(selected = selectedTabIndex == 1, onClick = {
            updateSelectedTabIndex(1)
        }) {
            Text(text = "Theatres")
        }

        Tab(selected = selectedTabIndex == 2, onClick = {
            updateSelectedTabIndex(2)
        }) {
            Text(text = "Showtimes")
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TabViewBootcampPreview() {
    TabViewBootcampComposable()
}


/*
In Jetpack Compose, it's generally not recommended to modify
the state of a parent composable from a child composable.
Instead, you should pass a callback function from the parent
composable to the child composable, and call that function
from the child composable when you need to modify the state.
 */