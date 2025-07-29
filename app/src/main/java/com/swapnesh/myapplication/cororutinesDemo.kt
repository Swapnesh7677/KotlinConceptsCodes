package com.swapnesh.myapplication

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun main(){
    //A suspending function is like a regular function, but it can be suspended and resumed again later.
    //Suspend function  should be called only from a coroutine or another suspend function.  ex delay()

   // runBlocking() is synchronous; it will not return until all work within its lambda block is completed.

   /* val time = measureTimeMillis {

        runBlocking {
            println("Weather forecast")
           *//* printForecast()
            printTemp()*//*
            launch {
                printForecast()
            }
            launch {
                printTemp()
            }

            launch(Dispatchers.IO) {
                println("IO: ${Thread.currentThread().name}")
            }
            launch(Dispatchers.Default) {
                println("Default: ${Thread.currentThread().name}")
            }
            *//*launch(Dispatchers.Main) {
                println("Main: ${Thread.currentThread().name}")
            }*//*
        }
    }
        println("Execution time: ${time / 1000.0} seconds")


    val result = coroutineScope {
        launch {
            launch {
                println("A")
            }
            coroutineScope {
                launch {
                    delay(500)
                    println("B")
                }
                delay(100)
                println("C")

            }
            println("D")
        }
        println("E")
    }
    println("F")*/

    var a: Deferred<String>? = null
    val time = measureTimeMillis {
     runBlocking {

        launch {

            printForecast()
            printTemp()


        }

    }
    }

    println("Execution time: ${time / 1000.0} seconds")

}

suspend fun printForecast() {
    delay(5000)
    println("Sunny")

}

suspend fun  printTemp(){
    delay(8000)
    println("30\u00b0C")
}