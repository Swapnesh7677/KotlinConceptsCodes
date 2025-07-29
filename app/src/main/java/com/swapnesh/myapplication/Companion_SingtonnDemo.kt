package com.swapnesh.myapplication

 /*A companion object is an object that is tied to a class
 rather than instances of the class*/

/*You can define methods and properties inside a companion object,
which can be accessed without an instance of the class.*/

class Companion_SingtonnDemo {
     companion object {
         val name = "Android jetpack"

          fun meassge(){
               println("This is Android Kotlin Companion object")
          }
     }
}


/*The Singleton  ensures a class has only one instance
throughout the application and provides a global point of access to it.
Kotlin makes it easy to implement this pattern using the object keyword.*/


object  Singleton{

    var counter = 0

    fun icrement(){
        counter++
        println(counter)
    }
}

fun main(){
    var  name =  Companion_SingtonnDemo.name
     println(name)
     Companion_SingtonnDemo.meassge()


  /*   name and printMessage() are accessed directly from MyClass
   without needing an object instance.*/

    Singleton.icrement()
    println(Singleton.counter)
}



