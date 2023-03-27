package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopAppBarBootcampComposable() {
    Column {
        LargeTopAppBar(
            title = {
                Text("I'm a large TopAppBar")
            },
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            },
            colors = TopAppBarDefaults
                .largeTopAppBarColors(Color.Red),

            modifier = Modifier.padding(bottom = 5.dp)
        )

        SmallTopAppBar(
            title = {
                Text("I'm a small TopAppBar")
            },
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            },
            colors = TopAppBarDefaults.largeTopAppBarColors
                (Color.Cyan),

            modifier = Modifier.padding(bottom = 5.dp)
        )

        MediumTopAppBar(
            title = {
                Text("I'm a medium TopAppBar")
            },
            navigationIcon = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.ArrowBack, null)
                }
            }, actions = {
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Share, null)
                }
                IconButton(onClick = {/* Do Something*/ }) {
                    Icon(Icons.Filled.Settings, null)
                }
            },
            colors = TopAppBarDefaults.largeTopAppBarColors
                (Color.Green),

            modifier = Modifier.padding(bottom = 5.dp)
        )
    }
}

@Preview
@Composable
fun TopAppBarBootcampPreview() {
    TopAppBarBootcampComposable()
}

/*

Scaffold.

Scaffold is a pre-built material design layout component in
Jetpack Compose, which provides an app bar, a floating action
button, and a body area to place your app content.

Scaffold in Jetpack Compose is a flexible layout component that
 can be used to build various components of an app. Some of the
 components that can be built using Scaffold include:

1. Basic screens: Scaffold can be used to create basic screens
with an app bar, a floating action button, and content.

2. Navigation drawer screens: Scaffold can also be used to
create screens with a navigation drawer that slides out from
the left side of the screen.

3. Tabs: Scaffold can be used to create screens with tabs that
switch between different sections of content.

4. Bottom navigation: Scaffold can be used to create screens
with a bottom navigation bar that allows users to switch between
different sections of the app.

5.Dialogs: Scaffold can be used to create dialogs that appear
on top of the app content.

6.Snack Bars: Scaffold can be used to display snack bars, which
are small messages that appear at the bottom of the screen.
 */

/*
TopAppBar -

In Jetpack Compose, the TopAppBar is a composable that creates
 a top app bar for your app

 The TopAppBar composable automatically arranges the title,
 navigation icon, and action icons in the app bar. It also
 handles things like scrolling, edge-to-edge content, and dark
  mode for you.
 */