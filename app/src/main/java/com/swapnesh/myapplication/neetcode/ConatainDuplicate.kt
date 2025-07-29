package com.swapnesh.myapplication.neetcode

fun main(){

   val list = intArrayOf(1,2,4,4,5,6,2)
    println(containDupliate(list))

    val list2 = intArrayOf(1, 3, 5,8)
    println(containDupliate(list2))

}


fun containDupliate(nums:IntArray):Boolean{
  //  return nums.size != nums.toSet().size

    var  seen  =  mutableMapOf<Int,Boolean>()
     for (num in nums){
         if(seen.containsKey(num)){
             return true
         }
         seen[num] =true
     }

    return false

}




/*
fun containDupliate(nums:IntArray):Boolean{

  //  return nums.size != nums.toSet().size


    val seen = mutableMapOf<Int,Boolean>()

    for (num in nums){
         if (seen.containsKey(num)){
             return true
         }
        seen[num] = true
    }
    return false

}*/
