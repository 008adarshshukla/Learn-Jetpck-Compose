package com.example.learnjetpackcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnackbarBootcampComposable() {

    var photoDeleted by remember {
        mutableStateOf(false)
    }
    val updateSnackbarHostState = remember {
        SnackbarHostState()
    }
    val doneSnackbarHostState = remember {
        SnackbarHostState()
    }
//The rememberCoroutineScope() function creates a CoroutineScope object that can be used to launch and manage coroutines. The CoroutineScope is a coroutine context that provides a way to launch new coroutines and manage their lifecycle. It also allows for cancellation of all the coroutines that were launched within the scope.
//
//By calling rememberCoroutineScope() within a Composable, you are creating a scope that is tied to the lifecycle of that Composable. This means that any coroutines launched within that scope will automatically be cancelled when the Composable is removed from the screen, preventing any potential memory leaks or unwanted behavior.
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        bottomBar = {
            BottomAppBar(
                contentColor = Color.Black,
                containerColor = Color(
                    red = 0xF0, green = 0xED, blue =
                    0xDF
                )
            ) {
                IconButton(onClick = {
                    coroutineScope.launch {
                        doneSnackbarHostState.showSnackbar(message
                        = "Photo Posted", duration = SnackbarDuration.Short)
                    }
                }) {
                    Icon(
                        Icons.Filled.Check,
                        contentDescription = "", tint = Color
                            .Black
                    )
                }
                IconButton(onClick = {
                     coroutineScope.launch { updateSnackbarHostState.showSnackbar(message =
                     "updated Photo", actionLabel = "Undo",
                         duration =
                     SnackbarDuration
                         .Short) }
                }) {
                    Icon(
                        Icons.Filled.Edit, contentDescription
                        = "", tint = Color.Black
                    )
                }
                IconButton(onClick = {

                }) {
                    Icon(
                        Icons.Filled.Delete,
                        contentDescription = "",
                        tint = Color
                            .Black,
                    )
                }
            }
        },
        snackbarHost = {
            Column {
                SecondSnackBar(snackbarHostState = updateSnackbarHostState)
                ThirdSnackBar(snackbarHostState = doneSnackbarHostState)
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}


//This is just using Snackbar.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstSnackbar() {
    Scaffold(
        snackbarHost = {
            Snackbar(
                modifier = Modifier.padding(
                    horizontal =
                    16.dp
                ),
                action = {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "Undo", color = Color.Red)
                    }
                },

                ) {
                Text(text = "Photo Deleted")
            }
        }
    ) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

        }
    }
}

//This is using SnackBarHost
@Composable
fun SecondSnackBar(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = {
            Snackbar(
                action = {
                    TextButton(onClick = { snackbarHostState
                        .currentSnackbarData?.dismiss()}) {
                        Text(text = "Undo", color = Color.Red)
                    }
                },
            ) {
                Text(text = "Updated Photo")
            }
        }
    )
}

//This is using SnackBarHost
@Composable
fun ThirdSnackBar(snackbarHostState: SnackbarHostState) {
    SnackbarHost(
        hostState = snackbarHostState,
        snackbar = {
            Snackbar(
                action = {
                    TextButton(onClick = { snackbarHostState
                        .currentSnackbarData?.dismiss()}) {
                        Text(text = "Ok", color = Color.Red)
                    }
                },
            ) {
                Text(text = "Posted the Photo")
            }
        }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SnackbarBootcampPreview() {
    SnackbarBootcampComposable()
}

/*
A Snackbar is a message that is shown briefly
at the bottom of the screen to inform the user about
a particular action or event. In Jetpack Compose, you can
use the Snackbar composable to show a Snackbar.

Building a Snackbar with just SnackBar composable is not
effective as it does not give benifits of queuing multiple
snackbar requests also it does not automativally removes
snackbar from the screen. All these features can be obtained
via using SnackbarHost

snackbarHostState property, which is an instance of the
SnackbarHostState class responsible for displaying the Snackbar.

showSnackbar is a function of the SnackbarHostState class that
 takes a SnackbarData object as a parameter. The SnackbarData
 object contains the message to display, the duration for
 which the Snackbar should be displayed, and the action to
 take when the action button is clicked.

The showSnackbar function of the SnackbarHostState class is a
suspend function. This means that it can only be called from
within a coroutine or another suspend function.


 */