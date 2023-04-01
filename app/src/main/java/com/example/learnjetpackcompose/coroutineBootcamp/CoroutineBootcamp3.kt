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


fun cooperativeCoroutine1() = runBlocking {
    println("Main program starts on : ${Thread.currentThread().name}")

    val kreiva: Job = launch {
        try {
            for (i in 0..500) {
                //boolean flag to make croutine cooperative
                print("$i.")
                Thread.sleep(1)
            }
        } catch (error: CancellationException) {
            print("\nException handled successfully.")
        }
        finally {
            withContext(NonCancellable) {
                print("Before suspending function")
                delay(10)
                print("After suspending function")
            }
        }
    }
    delay(10)
    kreiva.cancelAndJoin()
}

@Composable
fun CoroutineBootacmp3Composable() {
    Column {
        Spacer(modifier = Modifier.fillMaxHeight(0.5f))
        TextButton(onClick = {
            cooperativeCoroutine1()
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

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun CoroutineBootacmp3Preview() {
    CoroutineBootacmp3Composable()
}

/*
When we want to cancel the coroutine -
1. No longer needed
2. taking too long to respond.

Two ways to make coroutine cooperative -
1. Periodically invoke a suspending function that checks for cancellation. Only those functions
that belong to kotlinx.coroutine package will make coroutine cooperative. delay(), yield(),
withContext(), withTimeout() etc. are suspending function that belong to kotlinx.coroutine package.

2. Explicitly check for the cancellation status within the coroutine - CorouitneScope.isActive
boolean flag.

To cancel a coroutine it should be cooperattive.

Cancellable suspending finctions such as delay(), yeild() etc throw CancellationException on the
coroutine cancellation.

We can not normally execute a suspending function from the finally block because the coroutine
running this code is already can cancelled.

If it is necessary to execute a suspending function from finally block then wrap the code within
withContext(NonCancellable) function.

try {
    // code that may throw an exception
} catch (e: Exception) {
    // code to handle the exception
} finally {
    // code that will always be executed
}
In the above example, the try block contains the code that may throw an exception. If an
exception is thrown, the catch block is executed to handle the exception. Regardless of whether
an exception is thrown or not, the code in the finally block will always be executed.

The finally block is useful when you need to ensure that certain cleanup or resource release code
is executed even if an exception occurs. This could include closing database connections,
releasing file handles, or freeing up memory resources.

 */

/*
// define a ViewModel class

class MyViewModel : ViewModel() {
    private val _counter = mutableStateOf(0)
    val counter: State<Int> = _counter

    fun incrementCounter() {
        _counter.value++
    }
}

// create a Composable that uses the ViewModel
@Composable
fun MyScreen(viewModel: MyViewModel = viewModel()) {
    val counter = viewModel.counter.value
    Button(onClick = { viewModel.incrementCounter() }) {
        Text("Clicked $counter times")
    }
}


class CounterViewModel {
    private val _counter = MutableStateFlow(0)
    val counter: StateFlow<Int> = _counter.asStateFlow()

    fun incrementCounter() {
        _counter.value++
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel) {
    val counter by viewModel.counter.collectAsState()

    Column {
        Text(text = "Counter: $counter")

        Button(onClick = { viewModel.incrementCounter() }) {
            Text(text = "Increment")
        }
    }
}

 */