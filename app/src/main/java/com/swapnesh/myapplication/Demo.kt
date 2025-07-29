package com.swapnesh.myapplication

const val url = "www.google.com"
const val price = 43

fun main(){



    //empty list
    val emotylist : List<Int> = listOf()

    //collection in kotlin
    // lists, set, map
    val intlist : List<Int> = listOf(1,3,4,5,6)
    val stirnglist : List<String> = listOf("Sager","rahul", "partik")

    val setlist : Set<String> = setOf("ram","sham","kirshna","sham")

    val hashmap : Map<String, Int> = mapOf("sagar" to 21 ,"rahul" to 32)

    println(intlist)
    println(stirnglist)
    println(setlist)
    println(hashmap)





    var mav = "Saagr"
    println(mav)
    mav = "Gapal"
    println(mav)


    val num = 44
    println(num)
  //  num = 43  it will give you error or suggestion to change to var

  println(url)
    println(price*2)


    // safe call
    var number:Int? = 5  // null\
    var name:String? = "sagar" //null

    println(number?.inc())

    println( name?.length ?: 0)

    println(name!!.length)



}

