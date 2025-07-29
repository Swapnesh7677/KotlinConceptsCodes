package com.swapnesh.myapplication

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random.Default.nextInt

 fun main(){

    val name: String by lazy {
        println("Initlizing")
        "Swapnesh"
    }

    var p1 = Employee("Sagar", 32, 45)

    println("IS Adult-->${p1.isAdult()}")




        val myArrayList: ArrayList<Double> = ArrayList()
        myArrayList.add(13.212312)
        myArrayList.add(23.151232)
        myArrayList.add(32.651553)
        myArrayList.add(16.223817)
        myArrayList.add(18.523999)
        var total = 0.0
        for (i in myArrayList){
            total += i
        }
        var average = total / myArrayList.size
        println("Avarage is " + average)

    
    val str = "Kotlin Programming language"

    val word  = str.split(" ")
    val max = word.maxByOrNull { it.length }

    println(max)

    val d = str.split(" ")
    
    println(d)

    runBlocking {

        val co1 = async { task1() }

        val col2  = async { task2() }

        println(awaitAll(co1, col2))

    }

    val charPool: List<Char> = ('a'..'z') + ('A'..'Z')
    val result = (1..7)

        .map { nextInt(0, charPool.size) }

        .map(charPool::get)

        .joinToString("")

    println (result)

    val setA = mutableSetOf(1, 2, 3, 3, 2, 1)

    val setB = setOf(1, 2, 3, 1, 2, 3)

    println("$setA and $setB")

    println(setA == setB)
    println(setA === setB)

    println(name)

     runBlocking {
         nameLazy(name)
     }


}

suspend fun  nameLazy(name: String) {
    delay(8000)
    println(name)
}

suspend fun task1():String{
    delay(1000)
    return "sagar"
}

suspend fun task2():String{
    delay(2000)
    return "patil"

}

fun Employee.isAdult():Boolean{
    return age > 18
}

data class Employee( val name:String, val age:Int, val mark:Int)

sealed class  Notifiation(){


    data class  EMAIL(val sender:String, val subject:String):Notifiation()
    data class  SMS(val number:String, val message:String):Notifiation()
    data class  PushNotification(val title:String, val body:String):Notifiation()
}


fun HandleNotificationnew(notification: Notification){

    when(notification){
        is Notification.EMAIL -> println("Sender--${notification.sender}")
        is Notification.PushNotification -> println(notification.title)
        is Notification.SMS -> println(notification.message)
    }

}