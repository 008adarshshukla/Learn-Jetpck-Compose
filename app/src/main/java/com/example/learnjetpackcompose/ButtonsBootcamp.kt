package com.example.learnjetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonBootcampComposable(){
    Column() {

        //Button
        Button(onClick = { println("Button 1 Clicked") }) {
            Text(text = "Button 1")
        }

        //Outlined Button
        OutlinedButton(onClick = {
            println("Button 2 Clicked")
        },colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Green,
            contentColor = Color.Red,
            disabledContainerColor = Color.Blue,
            disabledContentColor = Color.Gray
        ), border = BorderStroke(width = 2.dp, color =
        Color.Blue)
        ) {
            Text(text = "Button 2")
        }

        //Text Button
        TextButton(onClick = { println("Text Button " +
                "Clicked") }) {
            Text("I'm a Text Button")
        }
    }
}

@Preview
@Composable
fun ButtonBootcampPreview() {
    ButtonBootcampComposable()
}