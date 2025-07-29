package com.swapnesh.myapplication

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

suspend fun main(){

   /* val simpleFlow:Flow<Int> = flow{
        for (i in 1..9){
            delay(1000)
            emit(i)
        }
    }

    simpleFlow.collect{values->
        println(values)
    }

    simpleFlow.collect{
        println(it)
    }*/


    runBlocking {
       // val channel = Channel<Int>()

        val buffChannel = Channel<Int>(capacity = 5)

        launch {
            for(i in 1..10){
              println("Sending--> $i")
              delay(100)
                buffChannel.send(i)
        }

            buffChannel.close()
        }

        for (i in buffChannel){
            println("receiving-->$i")
            delay(1500)
        }
    }


}


