package com.swapnesh.myapplication.interview.raw

import kotlinx.coroutines.*
import java.util.concurrent.Executors

fun main() = runBlocking {

    //Executors.newFixedThreadPool(4)
    //Creates a Java thread pool with 4 threads. This means at most 4 tasks can run in parallel.


    //.asCoroutineDispatcher()
    //Converts the Java thread pool into a Kotlin Coroutine Dispatcher,
    // which can be used to launch coroutines.


    val myDispatcher = Executors.newFixedThreadPool(4).asCoroutineDispatcher()

    repeat(10) { i ->
        launch(myDispatcher) {
            println("Task $i running on thread: ${Thread.currentThread().name}")
        }
    }

    delay(500) // Give coroutines time to finish
    myDispatcher.close() // Always close custom dispatchers to avoid memory leaks
}
//This is useful when you want fine control over how many threads your coroutines use,
// especially for:

//Limiting concurrency
//Isolating tasks from the default thread pools
//Integrating with legacy Java code
