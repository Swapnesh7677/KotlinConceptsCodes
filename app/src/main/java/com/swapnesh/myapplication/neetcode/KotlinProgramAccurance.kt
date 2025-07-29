package com.swapnesh.myapplication.neetcode

fun main(){

    val newstr = "aaabbfrwss"
   println(occurrence(newstr))

        // println(countCharacterOccurrences(newstr))


 //   println(charOccurrence("abbcddefffghhijkklmmm"))
    println(buildCount(newstr))
}

fun occurrence(str:String):String{
    val  strcom = StringBuilder()
    var count = 1

    for(i in 1 until str.length){
        if (str[i]==str[i-1]){
            count++
        }else{
            strcom.append(str[i-1]).append(count)
            count=1
        }

    }
    strcom.append(str.last()).append(count)
    return  strcom.toString()
}


fun countCharacterOccurrences(input: String): Map<Char, Int> {
    return input.groupingBy { it }.eachCount()
}



fun buildCount(str:String):String{

    val map = mutableMapOf<Char, Int>()

    for(i in str){
        map[i] = map.getOrDefault(i,0)+1
    }

    val result = map.entries.joinToString("") { "${it.key}${it.value}" }
    return result

}

