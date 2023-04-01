package com.example.learnjetpackcompose.coroutineBootcamp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.*

fun launchCoroutine() {
    // initially starts running on main thread

    //creates a coroutine that blocks the main thread.
    runBlocking {

        //runs on main thread.
        println("Program starts on ${Thread.currentThread().name}")

        //creates a corouitne that runs on same thread as that of parent
        // coroutine builder (runBlocking)
        val job: Job = launch { //Main thread
            println(
                "Fake task stars on ${
                    Thread.currentThread()
                        .name
                }"
            )
            //coroutine is suspended but thread T1 is free.
            delay(1000)

            //Either thread T1 or some other thread.
            //suspended function might chnage the thread.
            //delay function is a suspended function and cannot be
            //called from outside the coroutine.
            println(
                "Fake task end on ${
                    Thread.currentThread()
                        .name
                }"
            )
        }

        //runs on main thread wait for coroutine to finish
        job.join()
        //runs on main thread
        println("Program ends on ${Thread.currentThread().name}")
    }
}

fun asyncCoroutine() {
    // initially starts running on main thread

    //creates a coroutine that blocks the main thread.
    runBlocking {

        //runs on main thread.
        println("Program starts on ${Thread.currentThread().name}")

        //creates a corouitne that runs on same thread as that of parent
        // coroutine builder (runBlocking)
        val defferedJob: Deferred<String> = async { //Main thread
            println(
                "Fake task stars on ${
                    Thread.currentThread()
                        .name
                }"
            )
            //coroutine is suspended but thread T1 is free.
            delay(1000)

            //Either thread T1 or some other thread.
            //suspended function might chnage the thread.
            //delay function is a suspended function and cannot be
            //called from outside the coroutine.
            println(
                "Fake task end on ${
                    Thread.currentThread()
                        .name
                }"
            )

            return@async "Adarsh"
        }

        //getting the value returned by async coroutine builder.
        val name: String = defferedJob.await()
        //runs on main thread
        println("Program ends on ${Thread.currentThread().name}")
    }
}

@Composable
fun CoroutineBootcamp2Composable() {
    Column {
        Spacer(modifier = Modifier.fillMaxHeight(0.5f))
        TextButton(onClick = {



        }) {
            Row() {
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "Run Function")
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.fillMaxHeight(0.5f))
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CoroutineBootcamp2Preview() {
    CoroutineBootcampComposable()
}
/*
1. Coroutine builders are the functions used for building the coroutines.
2. Most important of them all are - launch, async, runBlocking.
3. Child coroutine builder runs on same thread as that of parent coroutine
   builder except if they are of global scope.

launch ------
Coroutine can be global(GlobalScole.launc{}) or local(launch{}).

It returns a job which can be used to cancel(cancel()) or wait(join()) for
it.

Suppose we have two Screens Login Screen and Homem Screen and they have
coroutines C1 and C2 which are local to the screens. We start from Login Screen where
weinitiatecoroutine C1 and then move to Home Screen where we initiate coroutine C2. Now we
navigate to the Login Screen this will result in coroutine C2 being destroyed. So coroutine
exist only till the life time of the Screen, as the screen is destroyed the corouitne will
cease to exist.

Global coroutines are the top-level coroutines which can survive the entire life of an
application.

Global scopes can be used for operations like File Download, Play Music etc.
Local scope can be used for operations such as Data computations, Login Operations.


async -----
It behaves similar to launch coroutine builder with few differences.

1. Returns a reference to the Deffered<T> objct. Using this we can cancel
the coroutine, wait for the coroutine or retrieve th result returned by it.
 */
