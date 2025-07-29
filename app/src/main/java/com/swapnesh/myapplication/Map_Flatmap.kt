package com.swapnesh.myapplication

fun main(){
    /*The map() function applies a transformation function to each element of a collection
            and returns a new collection with the transformed elements.*/

    /*The flatMap() function applies a transformation that produces a collection
    for each element and then merges the results into a single collection.*/

    val glocery = listOf(
        Bag(listOf("Apple","Mango","Orange","Banana")),
        Bag(listOf("Oil","Sugar","Pasta","Salt")),
        Bag(listOf("Chocolate","IceCream","Cake"))
    )

    val map = glocery.map { it.items }
    println(map)



    val flatmap = glocery.flatMap { it.items }
    println(flatmap)


    val listoflist = listOf(

        listOf(1,2,3),
        listOf(4,5,6),
        listOf(7,8,9)

    )

    val sqnumber = listoflist.flatMap{it ->
            it.map { it*it }

    }

    println(sqnumber)

    val numbers = listOf(1, 2, 3, 4, 5)
    val squaredNumbers = numbers.map { it * it }
    println(squaredNumbers)

    val mutiply = numbers.flatMap { listOf(it,it*2) }   //Doubling Elements with flatMap
    println(mutiply)

/*    val sentences = listOf("Kotlin is great", "I love programming")
    val wordsFlatMap = sentences.flatMap { it.split(" ") }
    println(wordsFlatMap)*/
}

data class Bag(
    val items:List<String>
)



//map() and flatMap() are higher-order functions used for transforming collections  in Kotlin.

/*
flatMap merges the two collections into a single one.

Map simply results in a list of lists.*/

/* Use map() when transforming elements individually and maintaining structure.
 Use flatMap() when each element is mapped to a collection and you want a single flat result.*/
