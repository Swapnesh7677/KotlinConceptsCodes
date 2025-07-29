package com.swapnesh.myapplication.palindrom_Prime_maxElement

fun main(){
    var input = "Madam"
   // var input = "Kotlin"

    println(isPalindrom(input))

    println(ispalindromusingLoop(input.lowercase()))

}

fun isPalindrom(input:String):Boolean{

    return input.lowercase() == input.lowercase().reversed()

}

fun ispalindromusingLoop(input:String):Boolean{

    var start = 0
    var end = input.length-1

    while (start < end){
        if (input[start] != input[end]) {
            return false
        }
        start++
        end--
    }
    return true

}