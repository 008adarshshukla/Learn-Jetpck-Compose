package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.sharp.Person
import androidx.compose.material.icons.twotone.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun IconsBootcampComposable() {
    Column() {
        Row() {
            Icon(imageVector = Icons.Rounded.Person,
                contentDescription = "Person Icon", tint =
                Color.Red, modifier = Modifier.size(20.dp))
            
            Text(text = "Rounded")
        }

       Row() {
           Icon(imageVector = Icons.Outlined.Person,
               contentDescription = "Person Icon", tint =
               Color.Red, modifier = Modifier.size(20.dp))

           Text(text = "Outlined")
       }

        Row() {
            Icon(imageVector = Icons.Default.Person,
                contentDescription = "Person Icon", tint =
                Color.Red, modifier = Modifier.size(20.dp))

            Text(text = "Default")
        }

        Row() {
            Icon(imageVector = Icons.Filled.Person,
                contentDescription = "Person Icon", tint =
                Color.Red, modifier = Modifier.size(20.dp))

            Text(text = "Filled")
        }

        Row() {
            Icon(imageVector = Icons.TwoTone.Person,
                contentDescription = "Person Icon", tint =
                Color.Red, modifier = Modifier.size(20.dp))

            Text(text = "TwoTone")
        }

        Row() {
            Icon(imageVector = Icons.Sharp.Person,
                contentDescription = "Person Icon", tint =
                Color.Red, modifier = Modifier.size(20.dp))

            Text(text = "Sharp")
        }
    }
}

@Preview
@Composable
fun IconsBootcampPreview() {
    IconsBootcampComposable()
}

/*
Important -
It takes 4 parameters:

1. imageVector – It is the image vector to be drawn in the
icon.

2. contentDescription – It is a text that describes the
icon. Accessibility services (like screen readers) use this text. If you don’t want this behavior, pass null.

3. modifier – To modify the layout of the icon.

4. tint – It is the icon color.
 */