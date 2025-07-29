package com.swapnesh.myapplication

fun main(){

    //Scope function are functions that executes block of code with in the context of object.
    //let, run, with, apply, also

    //1.return type
    //2. context of object
    //3. Context renaming
    //4.null check possible for let, run, apply, also but not in with


    var user = User("Sager","Patil",32,"M")


    var letvaiable = user.let{
        it.name

    }
    println(letvaiable)

    //when you want to executes multiple operation on object and return a result other than the object.

    var runvaiable =user.run{
            this.name +"Kumar"

    }
    println(runvaiable)

    var withvaiable = with(user){
            age> 30
    }
    println(withvaiable)


    var applyVaribale = user.apply{
        this.name  = "Rahul"

    }
    println(applyVaribale)

    var alsoVaribale = user.also{
        it.name  = "Rahul"
    }
    println(alsoVaribale)


}


data class  User(
    var name: String,
    var last: String,
    var age: Int,
    var gender :String
)