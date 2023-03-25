package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardsBootcampComposable() {
    Card(shape = RectangleShape, elevation =
    CardDefaults.cardElevation(10.dp), modifier = Modifier
        .padding(10.dp), colors = CardDefaults.cardColors
        (Color.White)) {
        Text(text = "I love a girl", modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp))
    }
}

@Preview
@Composable
fun CardsBootcampPreview() {
    CardsBootcampComposable()
}

/*
The @OptIn annotation in Kotlin is used to opt into experimental APIs,
which are features that are not yet stable or fully supported but are
available for testing and feedback.

In this case, ExperimentalMaterial3Api is an experimental API provided
by the androidx.compose.material3 library, which is an experimental
version of the Material Design components for Jetpack Compose.

When you use the @OptIn(ExperimentalMaterial3Api::class) annotation in
your code, you are explicitly indicating that you are aware that you
are using an experimental API, and that you understand the risks
associated with using it, such as potential changes or removal in
future releases.
 */

