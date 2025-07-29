package com.swapnesh.myapplication.palindrom_Prime_maxElement

fun main(){
    println(isPrime(44))
}

fun isPrime(int: Int):Boolean{
    if(int <= 1) return false

    for (i in 2 until int){

        if (int % 2 == 0) return false
    }
    return true

}