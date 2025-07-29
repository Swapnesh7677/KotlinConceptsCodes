package com.swapnesh.myapplication.neetcode

fun main(){

        // asked in two interview //raw and mphacis
    val array = intArrayOf(4,0,3,0,5,0,1,0,2,0)

    val nonzero  = mutableListOf<Int>()
    val zeros = mutableListOf<Int>()

    for(i in array.sorted()){
        if(i>0){
            nonzero.add(i)
        }
        else{
            zeros.add(i)
        }
    }

    val combine = nonzero+zeros

    println(combine)
}