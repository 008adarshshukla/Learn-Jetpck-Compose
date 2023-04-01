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
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//Note - Here main() waits for background threads to finish
// its execution before it ends.
fun threadLearning() {
    //runs on main thread
    println("Program starts on ${Thread.currentThread().name}")

    //runs on background thread.
    thread {
        println(
            "Fake task stars on ${
                Thread.currentThread()
                    .name
            }"
        )
        Thread.sleep(1000)
        println(
            "Fake task end on ${
                Thread.currentThread()
                    .name
            }"
        )
    }

    //runs on main thread
    println("Program ends on ${Thread.currentThread().name}")
}

//main() does not by deafult wait for coroutine execution.
fun coroutineLearning() {
    //runs on main thread
    println("Program starts on ${Thread.currentThread().name}")

    //creates a corouitne that runs on background thread.
    GlobalScope.launch {
        println(
            "Fake task stars on ${
                Thread.currentThread()
                    .name
            }"
        )
        Thread.sleep(1000)
        println(
            "Fake task end on ${
                Thread.currentThread()
                    .name
            }"
        )
    }

    //runs on main thread
    println("Program ends on ${Thread.currentThread().name}")
}

fun delayLearning() {
    //runs on main thread
    println("Program starts on ${Thread.currentThread().name}")

    //creates a corouitne that runs on background thread lets
    // say thread T1
    GlobalScope.launch {
        println(
            "Fake task stars on ${
                Thread.currentThread()
                    .name
            }"
        )
        //coroutine is suspended but thread T1 is free.
        delay(5000)

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

    //runs on main thread
    println("Program ends on ${Thread.currentThread().name}")
}


//GlobalScope.launch{} launches a coroutine that is non blocking
//in nature while runBlocking launches a coroutine that blocks
//the current on which it operates and the coroutine is created
//on the same thread.
fun globalScopeVSRunBlocking() {
    // initially starts running on main thread

    //creates a coroutine that blocks the main thread.
    runBlocking {

        //runs on main thread.
        println("Program starts on ${Thread.currentThread().name}")

        //creates a corouitne that runs on background thread lets
        // say thread T1
        GlobalScope.launch {
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
        delay(2000)
        //runs on main thread
        println("Program ends on ${Thread.currentThread().name}")
    }
}


@Composable
fun CoroutineBootcampComposable() {
    Column {
        Spacer(modifier = Modifier.fillMaxHeight(0.5f))
        TextButton(onClick = {

            globalScopeVSRunBlocking()

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
fun CoroutineBootcampPreview() {
    CoroutineBootcampComposable()
}

/*
When the user launches an a default thread is assigned to it
called the main thread. The main thread in Kotlin is generally
the same each time the application is launched.

The main thread should be used to perform the light weight
operations, such as UI interactions, Button Clicks, Samll
Computations.

Running heavy operations such as Networking, File Download,
Image loading, Database queries on main thread will result it
in being frozen. Foe heavy operations we can use worker or
background thread.

Although creating thread seems to solve the problem, but we
cannot create large number of threads as this will exhaust
the memory.

Here coroutine Seems to solve the problem as we can create
multiple coroutines on a particular background thread to
perform heavy operations.

Coroutines are ligth weight threads which can run in parallel,
wait and communicate with each other.

Note - Coroutines are not threads. As creation od coroutine
are very cheap in comparison to threads. Unlike threads, for
coroutines the application by deafult does not wait for it to
finish its excution.

Thraed.sleep blocks the thread for a particular time, but
delay function blocks the coroutine on the thread. Other
coroutines are not affected and they contunue to execute
independent of currently blocked one.

A function with a 'suspend' modifier is called suspending
function. The suspending function can only be called from
another suspending function or a coroutine.

 */