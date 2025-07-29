package com.swapnesh.myapplication.interview.raw


fun main(){

   /* var u1 = User("Swapnesh",30)

    println(u1.isAdult())*/


    var str = "Swapnesh"

   println(reversting(str))

    var array = intArrayOf(2,0,4,0,5,0,1,0,3,0)

    var zeros = mutableListOf<Int>()
    var nonzeros = mutableListOf<Int>()

    for( j in array.sorted()){

        if(j>0){
            nonzeros.add(j)
        }else{
            zeros.add(j)
        }
    }
    val combine  = nonzeros + zeros

    println(combine)

    //==============

    var sortedarray = array.sorted()

    var output = sortedarray.takeLast(5) + sortedarray.dropLast(5)
    println(output)


    var num = intArrayOf(2, 4, 3, 5, 7, 8, -1)
    var target = 7

    sumtarget(num,target)
}

fun sumtarget( num:IntArray, target:Int){

    val map  = mutableMapOf<Int, Int>()

    for(i in num){

        if(num[i] + num[i+1] == target){
            map[i]
        }
    }

    println(map)





}




fun reversting(str:String):String{
    var newstr = ""


    for(i in str.length-1 downTo 0){
        newstr += str[i]
    }
    return newstr
}

/*
fun User.isAdult():Boolean{
    return age>18
}

data class  User(val name:String, val age:Int)*/
