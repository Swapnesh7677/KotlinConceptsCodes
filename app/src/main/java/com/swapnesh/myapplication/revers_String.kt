package com.swapnesh.myapplication



fun main(){
    //val input = "hello kotlin"
    val input = "I love programing"

    // Split the input string into words
    val words = input.split(" ")

    // Reverse each word manually
    val reversedWords = words.joinToString(" ") { word ->
        var reversedWord = ""
        for (i in word.length - 1 downTo 0) {
            reversedWord += word[i]
        }
        reversedWord
    }
    println(reversedWords)

 //   val out = input.split(" ").joinToString(" "){ it.reversed() }

    //println(out)



   val str = "Harry potter"
    val result = rvString(str)
    println("result-->$result")

}

fun rvString(str:String):String{

    val splitstr =  str.split(" ")

    val reversedStr = splitstr.joinToString(" "){ it->
        var rvstr = ""
        for(i in it.length-1 downTo 0){
            rvstr +=it[i]
        }
        rvstr

    }
    println(reversedStr)
   // return  reversedStr


    //another way
    return  str.split(" ").joinToString(" "){
        it.reversed()
    }
}

