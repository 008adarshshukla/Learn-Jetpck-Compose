package com.example.learnjetpackcompose.NavigationBootcamp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

/*
Components of Navigation -
1. Nav Controller - Its main purpose is to keep track of the back stack and the composable screen
. Its a good practice to place nav controller to place high in the view hierarchy.
2. Nav Host - Its main purpose is to define a navigation graph. So basically inside the nav host
we can define all our screens, its routes, arguements and all other specific requirements. Also
here we can define our start destination.
 */


@Composable
fun NavigationHomeScreen(navControlller: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navControlller.navigate(route = Screens.Details.route)
            },
            text = "Home Screen",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationHomeScreenPreview() {
    NavigationHomeScreen(navControlller = rememberNavController())
}


@Composable
fun NavigationDetailsScreen(navControlller: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.clickable {
                navControlller.popBackStack()
            },
            text = "Deatils Screen",
            color = MaterialTheme.colorScheme.primary,
            fontSize = MaterialTheme.typography.headlineSmall.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDetailsScreenPreview() {
    NavigationDetailsScreen(navControlller = rememberNavController())
}

@Composable
fun SetupNavGraph(navControlller: NavHostController) {
    NavHost(
        navController = navControlller,
        startDestination = Screens.Home.route
    ) {
        //declare all our destinations.

        //this the starting destination details
        composable(
            route = Screens.Home.route
        ) {
            NavigationHomeScreen(navControlller = navControlller)
        }

        //details of ther destinations---

        //Details of the details Destination.
        composable(route = Screens.Details.route) {
            NavigationDetailsScreen(navControlller = navControlller)
        }
    }
}
