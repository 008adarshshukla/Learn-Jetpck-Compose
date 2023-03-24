package com.example.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*



class TextBootcamp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContentView()
        }
    }
}

@Composable
fun ContentView () {
    Column() {
        Text(text = "I adarsh shukla",
            fontFamily = FontFamily.Cursive,
            color = Color.Yellow,
            fontWeight = FontWeight(16),
            fontSize = 20.sp,
            style = TextStyle(textDecoration =
            TextDecoration.Underline)
        )
    }
}

@Preview
@Composable
fun MyPreview() {
    ContentView()
}