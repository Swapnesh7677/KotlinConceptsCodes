package com.swapnesh.myapplication.revesdString

fun  main(){

    var input = "Programming Kotlin"




    println(reversedString_usingFuntion(input))

    println(reversedString_usingLoop(input))

}

fun reversedString_usingFuntion(input:String):String{
    return input.reversed()
}

fun reversedString_usingLoop(input: String):String{
   var result = ""

    for(i in input.length-1 downTo 0){
        result += input[i]
    }
    return  result

}

