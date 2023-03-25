package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatingActionButtonComposable() {
    Column() {
        FloatingActionButton(
            onClick = { /*Action To be Performed*/ },
            containerColor = Color.Blue
        ) {
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Heart Icon", tint =
                Color.Red
            )
        }

    }
}

@Preview
@Composable
fun FloatingActionButtonPreview() {
    FloatingActionButtonComposable()
}