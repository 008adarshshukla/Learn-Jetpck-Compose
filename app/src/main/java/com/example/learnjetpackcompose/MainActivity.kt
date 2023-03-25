package com.example.learnjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnjetpackcompose.ui.theme.LearnJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun HomeView() {
    Column {
        Text(text = "My first Compose application.")
        Text(text = "Checking".repeat(10), fontWeight =
        FontWeight.Bold, softWrap = true)

        Text(text = "Padding",
            Modifier
                //.padding(10.dp)
                .background(color = Color.Green)
                .padding(10.dp)
                //.offset(x = 20.dp)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ShapesBootcampComposable()
}
/*
Concept of Composition and Recomposition-
In compose when we want to change the internal state of a
 composable then we just call the composable function
 agian with the new data. By this the ui handled by that
 composable will be redrawn and rerendered
 */
/*
Important points regarding composable functions-
1. Can be executed in any order. Compose can prioritise
some some composable functions and draw them first.
2. Can execute in parallel.
3. Recomposition skips as many as composable functions
and lambdas as possible.
4. Recomposition is optimistic and may be cancelled. This
 happens when the parameters change while the
 recomposition, this leads to stopping of the first
 recomposition and starting a new one.
5. A composable function might run quite frequently as
often as every frame of animation. So heavy work must be 
performed outside the composable function, on a different
 thread to avoid the ui lags.
 */
/*
States-
# State is any value that can change over time.
# In compose UI is immutable which means we cannot update
the ui after it has been drawn, We can however control 
the state of the UI. Every time the state of the UI
Changes Compose recreates the parts of the UI that are
affected via the state change.
# Event is to notify a part of program that something has
 happened
 */
