package com.swapnesh.myapplication.Testing

class Engine (

    val cc:Int,
    val hoursepower:Int,
    var temp:Int,
    var isturnedOn:Boolean
){
    fun turnOn(){
        isturnedOn = true
        temp = 95
    }

    fun turnedOff(){
        isturnedOn = false
        temp=15
    }

}

