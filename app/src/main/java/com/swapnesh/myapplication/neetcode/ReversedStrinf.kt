package com.swapnesh.myapplication.neetcode

fun main(){

    //raw
    val str = "Kotlin Programming"

    val words = str.split(" ")

    val rvstr = words.joinToString(" ") { word ->
        var newstr = ""
        for(i in word.length-1 downTo  0){
            newstr += word[i]
        }
        newstr
    }

    println(rvstr)
}