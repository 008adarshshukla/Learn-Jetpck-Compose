package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SpacerBootcampComposable() {
    Column() {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Fist text")
            Spacer(modifier = Modifier.fillMaxHeight(0.5f))
            Row() {
                Text(text = "Third text")
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Fourth txt")
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "Second text")

        }
    }
}


@Preview
@Composable
fun SpacerBootcampPreview() {
    SpacerBootcampComposable()
}

/*
Note -
Spacer with the weight parameter has similar behaviour
as that in swiftUI
 */