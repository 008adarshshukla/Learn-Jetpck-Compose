package com.example.learnjetpackcompose.NavigationBootcamp

sealed class Screens(val route: String) {
    object Home: Screens(route = "home_screen")
    object Details: Screens(route = "details_screen")
    object Details2: Screens(route = "details_screen2")
}
