package com.swapnesh.myapplication.interview.congi

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow

import kotlinx.coroutines.runBlocking

fun main(){


 /* val list = listOf<Int>(1,2,3,4,5)

  println(list.asFlow())*/

 runBlocking {
  flow<Int> {
   for( i in 1..10){
    emit(i)
   }
  }.collect(){it->
   delay(1000)
   println(it)

  }



 }

 Singeton.dosomething()


}

interface api {
 fun default()
}


  data class User(val name:String) :api{
   override fun default() {
    TODO("Not yet implemented")
   }
  }




object Singeton{
 var count = 0


 fun dosomething(){
  count++
  println(count)
 }
}




