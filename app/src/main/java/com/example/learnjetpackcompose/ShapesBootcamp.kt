package com.example.learnjetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class ShapesBootcamp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShapesBootcampComposable()
        }
    }
}

@Composable
fun ShapesBootcampComposable() {
    Box(
        modifier = Modifier
            .size(100.dp)
            //.background(Color.Blue)
            .drawWithContent {
                drawCircle(
                    color = Color.Yellow,
                    radius = size.minDimension / 2,
                    center = Offset(size.width / 2, size.height / 2)
                )
                drawContent()
            }
    )
}

@Preview
@Composable
fun MyPreviewShapesBootcamp() {
    ShapesBootcampComposable()
}