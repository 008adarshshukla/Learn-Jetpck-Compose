package com.example.learnjetpackcompose.NavigationBootcamp

const val DETAIL_ARGUMENT_KEY = "id"
const val DETAIL_ARGUMENT_KEY2 = "name"

sealed class Screens(val route: String) {
    object Home: Screens(route = "home_screen")

    //passing the parameter id to details screen.
    object Details: Screens(route = "details_screen/{$DETAIL_ARGUMENT_KEY}/{$DETAIL_ARGUMENT_KEY2}") {

        //for single argument
//        fun passId(id: Int): String {
//            return this.route.replace(oldValue = "{$DETAIL_ARGUMENT_KEY}", newValue = id.toString())
//        }

        fun passNameAndId(id: Int, name: String): String {
            return "details_screen/$id/$name"
        }
    }
    object Details2: Screens(route = "details_screen2")
}
