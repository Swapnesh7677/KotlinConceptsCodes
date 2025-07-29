package com.swapnesh.myapplication.flows

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(){


    val list = listOf<String>("Sagar","Rahul","Vivek","Gopal")

    val flowasdata = list.asFlow()

    val flowof = flowOf("Sagar","Rahul","Vivek","Gopal")


    runBlocking {
        simpleflow().collect() { value ->
            println(value)
            println("====")

        }

        flowasdata.collect(){data->
            println(data)

        }
        flowof.collect(){
            println("====")
            println(it)

        }

        concurrentflow().collect(){
            println("+++++")
            println(it)
        }
    }


}

fun simpleflow(): Flow<Int> = flow {
    for (i in 1..10){
        delay(500)
        emit(i)
    }
}

fun concurrentflow() :Flow<Int> = channelFlow {

    launch {
        send(2)
        send(4)
        send(6)
    }

    launch {
        send(3)
        send(6)
        send(9)
    }

    launch {
        send(5)
        send(10)
        send(15)
    }
}



