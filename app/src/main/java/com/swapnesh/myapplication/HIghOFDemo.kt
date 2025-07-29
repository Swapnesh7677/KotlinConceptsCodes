package com.swapnesh.myapplication

fun main(){

    val sum = calculate(3,5){
        a,b->a+b
    }
    println(sum)

    val mul = calculate(5,6){
        a,b -> a*b
    }
    println(mul)



    val sumresult = calculate(10,20 ,::sum)
    println(sumresult)


    val multi = calculate(2,7 ){
        a,b ->a*b
    }

    println("multiplcation->${multi}")

    val mutli2 = calclualte(3,76,::multi)
    println("multiplcation2---->${mutli2}")

}



 /*fun calculate(a:Int, b:Int,op:(Int,Int)->Int):Int{
    return  op(a,b)
}*/
 fun sum(x:Int,Y:Int) = x+Y

fun calculate(a:Int, b:Int,op:(Int, Int)->Int):Int{
    return op(a,b)
}

fun multi(x:Int, y:Int) = x*y