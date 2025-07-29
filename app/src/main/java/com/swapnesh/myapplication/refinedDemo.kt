package com.swapnesh.myapplication

fun main(){

   /* displayValue<String>(String::class.java,"genric")
    displayValue<Int>(Int::class.java,10)*/

    displayValue("sagrer")
   displayValue(10)


}



/*fun <T> displayValue(value :T){
    println(value)
    println("type ot T: ${T::class.java}")
}*/

/*fun <T> displayValue(classtype: Class<T>,value: T){
    println(classtype)
    println("type ot T: $classtype")
}*/


inline fun <reified T> displayValue(value: T){
    println(value)
    println("type of T: ${T::class.java}")

}


/*inline fun <reified  T> displayValue(value: T){
    println(value)
    println("type of T: ${T::class.java}")
}*/
