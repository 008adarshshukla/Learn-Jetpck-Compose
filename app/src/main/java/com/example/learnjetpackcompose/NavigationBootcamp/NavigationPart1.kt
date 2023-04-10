package com.example.learnjetpackcompose.NavigationBootcamp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
        Column() {
            Text(
                modifier = Modifier.clickable {
                    navControlller.navigate(route = Screens.Details2.route)
                },
                text = "Details Screen",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.clickable {
                    navControlller.popBackStack()
                },
                text = "Go to home screen",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDetailsScreenPreview() {
    NavigationDetailsScreen(navControlller = rememberNavController())
}

@Composable
fun NavigationDetailsScreen2(navControlller: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column() {
            Text(
                text = "Last Screen",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.clickable {
                    navControlller.navigate(route = Screens.Home.route) {
                        popUpTo(Screens.Home.route) {
                            //This means that we want to remove even the
                            //home screen from the back stack.

                            inclusive = true
                        }
                    }
                },
                text = "Go to home screen directly",
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NavigationDetailsScreen2Preview() {
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

        composable(route = Screens.Details2.route) {
            NavigationDetailsScreen2(navControlller = navControlller)
        }
    }
}

//When navigating to a new view, the current view is added to the backstack and the new view
// becomes the current view. This allows us to go back to the previous view by pressing the back
// button, which pops the current view off the backstack and restores the previous view.

/*
Note - During the navigation every view gets in the backstack. Even the start destination is
present in the back stack.

In Jetpack Compose, the start destination is typically not present in the backstack when the app
is launched. The start destination is the first screen that the user sees when they open the app
or navigate to a particular flow within the app.

When the app is launched, the start destination is added to the backstack as the first
destination. However, it is not added to the backstack again when the user navigates back to it
from other screens.

This behavior is controlled by the popUpTo and inclusive parameters in the NavController.navigate
function. By default, when navigating to a destination that is already present in the backstack,
the existing instance of the destination is brought to the top of the stack instead of creating
a new instance.

So, when the user navigates back to the start destination, the existing instance is brought to
the top of the stack instead of creating a new instance. This means that the start destination is
not added to the backstack again.

However, it is possible to change this behavior and add the start destination to the backstack
again by using the popUpTo and inclusive parameters to clear the backstack up to the start
destination, and then navigate to the start destination again. This will create a new instance of
the start destination and add it to the backstack as the first destination.
 */