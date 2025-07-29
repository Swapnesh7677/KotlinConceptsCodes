package com.swapnesh.myapplication

fun main(){

    val input = listOf(10, 20, 30, 40, 50, 60)

    val ot = input.takeLast(2) + input.dropLast(2)

    println(ot)






    val inputarray = listOf(1,0,5,0,4,0,2,0,3,0)
    val sorted = inputarray.sorted()
    println(sorted)
    val output = sorted.takeLast(5) + sorted.dropLast(5)
     println(output)




}

//takelast() --Returns a list containing the last n elements of the original list

//droplast()-- Returns a list with the last n elements removed.