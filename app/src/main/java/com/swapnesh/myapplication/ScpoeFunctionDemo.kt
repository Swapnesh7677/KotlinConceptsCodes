package com.swapnesh.myapplication

fun main(){

   /*val list = mutableListOf(1,3,4,5,6,8)

   list.also {
       it.add(1,2)
       it.remove(8)
   }

    println(list)*/



    val list = intArrayOf(5, 0, 2, 0, 4, 0, 3, 0, 1, 0)
    val nonZeroSorted = list.filter { it != 0 }.sorted()
    val result = nonZeroSorted + IntArray(list.size - nonZeroSorted.size) { 0 }
    println(result.joinToString(", "))





        val list2 = intArrayOf(5, 0, 2, 0, 4, 0, 3, 0, 1, 0)
        val result2 = MutableList(list.size) { 0 } // Initialize with zeros

        // Extract non-zero elements and sort them
        val nonZero = mutableListOf<Int>()
        for (num in list2) {
            if (num != 0) {
                nonZero.add(num)
            }
        }
        nonZero.sort()

        println(nonZero)

        // Copy sorted non-zero elements into result
        for (i in nonZero.indices) {
            result2[i] = nonZero[i]
        }

        println(result2.joinToString(", "))


}