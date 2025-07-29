package com.swapnesh.myapplication.neetcode

import android.annotation.SuppressLint

fun main(){

    var s =  "rat" //"Listen"  //"rat"//
    var t =  "car"//"silent"  // "car"//

    println("IS anagram --->${anagram(s,t)}")
    println("IS anagram --->${checkAngarm(s,t)}")



}

fun anagram(str:String, str2:String):Boolean{

    var clerstr = str.lowercase().filter { it.isLetter() }.toCharArray().sorted()
    var clestr1 = str2.lowercase().filter { it.isLetter() }.toCharArray().sorted()

    return clerstr == clestr1
}

fun checkAngarm(str: String,str2: String):Boolean{

    fun buildCharCount(s:String):Map<Char,Int>{

        var map = mutableMapOf<Char,Int>()

        for(i in s.lowercase()){

            if(i.isLetter()){
                map[i] = map.getOrDefault(i,0)+1
            }
        }


     return map
    }

    return buildCharCount(str) == buildCharCount(str2)
}

/*
@SuppressLint("SuspiciousIndentation")
fun anagram(str: String, str1:String):Boolean{

    if (str.length != str1.length){
        return false
    }

    var clenstr = str.lowercase().filter { it.isLetter() }.toCharArray().sorted()

    var clenstr2 = str1.lowercase().filter { it.isLetter() }.toCharArray().sorted()

        return clenstr == clenstr2
}

fun checkAnagram(s:String, t:String):Boolean{

    fun buildCharCount(str:String):Map<Char,Int>{

        var map = mutableMapOf<Char,Int>()

        for(char in str.lowercase()){

            if(char.isLetter()){
                map[char] = map.getOrDefault(char,0)+1
            }
        }
        return  map
    }

    return buildCharCount(s) == buildCharCount(t)

}*/
