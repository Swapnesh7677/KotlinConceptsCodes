package com.swapnesh.myapplication.vowels

fun main(){
    val result = countVowels("SwapneshKhachane")
    println(result)
}

fun countVowels(input:String):Int{
    return input.count { it in "aeiouAEIOU" }
}