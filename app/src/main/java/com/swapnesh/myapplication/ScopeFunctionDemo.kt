package com.swapnesh.myapplication

fun main(){

    val person = Person("sagar",34)

     with(person){
        println(name)
         println(name + "Rane")
        println(age)
        println(age+5)
    }


    person.apply {
        name = "Swapnesh"
        age = 32
    }

    println(person)


    person.run { 
        name = "Gopal"
    }
    println(person)

}

data class Person(var name:String,var age:Int)