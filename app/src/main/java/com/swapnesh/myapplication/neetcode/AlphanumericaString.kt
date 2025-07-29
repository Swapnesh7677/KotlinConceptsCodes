package com.swapnesh.myapplication.neetcode

fun main(){

    var alphanumericString= "abc123xyz456"

    val letter = alphanumericString.filter { it.isLetter() }

    val num = alphanumericString.filter { it.isDigit() }

    println(letter)
    println(num)
}