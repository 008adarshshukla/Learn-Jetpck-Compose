package com.example.learnjetpackcompose


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ShapesBootcampComposable() {
    Column {

        //Rounded Corner Shape.
        Surface(modifier = Modifier.padding(8.dp),
            //border = BorderStroke(2.dp, Color.Red),
            color = Color.Red,
            contentColor = Color.Blue,
            shape = RoundedCornerShape(8.dp),
            tonalElevation = 3.dp,
            shadowElevation = 20.dp
        ) {
            Text(text = "Hello World !!", modifier = Modifier.padding(4.dp))
        }

        //Circle Shape
        Surface(modifier = Modifier.padding(8.dp),
            //border = BorderStroke(2.dp, Color.Red),
            color = Color.Red,
            contentColor = Color.Blue,
            shape = CircleShape,
            tonalElevation = 3.dp,
            shadowElevation = 20.dp
        ) {
            Text(text = "Hello World !!", modifier = Modifier.padding(4.dp))
        }

        //CutCornerShape
        Surface(modifier = Modifier.padding(8.dp),
            //border = BorderStroke(2.dp, Color.Red),
            color = Color.Red,
            contentColor = Color.Blue,
            shape = CutCornerShape(
                //the size of the cut corner.
                corner = CornerSize(4.dp)
            ),
            tonalElevation = 3.dp,
            shadowElevation = 20.dp
        ) {
            Text(text = "Hello World !!", modifier = Modifier.padding(4.dp))
        }

        //CutCornerShape
        Surface(modifier = Modifier.padding(8.dp),
            //border = BorderStroke(2.dp, Color.Red),
            color = Color.Red,
            contentColor = Color.Blue,
            shape = CutCornerShape(4.dp),
            tonalElevation = 3.dp,
            shadowElevation = 20.dp
        ) {
            Text(text = "Hello World !!", modifier = Modifier.padding(4.dp))
        }

        //CutCornerShape
        Surface(modifier = Modifier.padding(8.dp),
            //border = BorderStroke(2.dp, Color.Red),
            color = Color.Red,
            contentColor = Color.Blue,
            shape = CutCornerShape(topStart = 3.dp,
                bottomStart = 4.dp, topEnd = 5.dp,
                bottomEnd = 6.dp),
            tonalElevation = 3.dp,
            shadowElevation = 20.dp
        ) {
            Text(text = "Hello World !!", modifier = Modifier.padding(4.dp))
        }

        //TriangleShape
        Surface(modifier = Modifier.padding(8.dp),
            //border = BorderStroke(2.dp, Color.Red),
            color = Color.Red,
            contentColor = Color.Blue,
            shape = RectangleShape,
            tonalElevation = 3.dp,
            shadowElevation = 20.dp
        ) {
            Text(text = "Hello World !!", modifier = Modifier.padding(4.dp))
        }
    }
}



@Preview(showBackground = true)
@Composable
fun MyPreviewShapesBootcamp() {
    ShapesBootcampComposable()
}

/*
The surface can be used to build any shapes.
 */