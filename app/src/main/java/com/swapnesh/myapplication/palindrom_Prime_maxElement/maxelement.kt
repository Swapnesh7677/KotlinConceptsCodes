package com.swapnesh.myapplication.palindrom_Prime_maxElement

fun main(){
    val number = intArrayOf(1,3, 5,8,9, 33,55,40,88)

    var result = findmax(number)
    var maxsort = maxElementSort(number)
    var maxloop = maxbyloop(number)

    println(result)
    println(maxsort)
    println(maxloop)
}

fun findmax(arr:IntArray):Int{
    return arr.maxOrNull()!!
}

fun maxElementSort(arr: IntArray):Int{
    return arr.sorted().last()

}

fun maxbyloop(arr: IntArray):Int{
    var max = arr[0]

    for(num in arr){
        if(num  >  max){
            max = num
        }
    }
    return max
}