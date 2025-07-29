package com.swapnesh.myapplication

fun main(){
        //Extension function
    val student = Student("Rachin",45,22)

    val listStudent = listOf(Student("Rohit",76,23),
        Student("Shubman",31,16),
        Student("Virat",1,17),
        Student("Shreyas",48,22))


    println(student.isPassed())
    println(listStudent.isPassedName())
    println("IS Adult-->${student.isAdult()}")
    println("Adult List Name-->${listStudent.adultlistname()}")


    //Higher order functions

   /* val sum = calculate(10,39){
        a,b -> a+b
    }

    val multiple = calculate(55,34){
        a,b -> a*b
    }

    println(sum)
    println(multiple)*/


    val result1 = cal(23, 55 ,::add)
    println(result1)

    val mulresult = cal(3,8 , :: mautiply)
    println(mulresult)

    var messgae :String = "Kotlin"

   print(messgae.addExclmation())
    println(student.pass())

    var sum  = calclualte(2,5){
         a,b -> a+b
    }
    println(sum)


}

fun Student.isPassed(): String {
    return if (mark>30)  "Passed" else "Failed"
}

fun Student.pass():String{
    return if (mark>30) "pass" else "Fails"
}

fun List<Student>.isPassedName():List<String>{
        return this.filter { it.mark>35 }.map { it.name }
}

data class  Student(var name:String, var mark:Int,var age:Int)

/*
fun calculate( a:Int, b:Int, operation:(Int,Int)->Int):Int{
    return operation(a,b)
}
*/


fun cal (x:Int, y:Int, operation:(Int, Int)->Int):Int{
    return operation(x,y)
}

fun calclualte( a:Int,b:Int , op:(Int, Int)->Int):Int{
    return op(a,b)
}


fun add(X:Int, Y:Int):Int{
    return  X+Y
}

fun mautiply(a:Int, b:Int):Int{return a*b}




//extesnion function

fun String.addExclmation():String{
    return "$this!"
}


fun Student.isAdult():Boolean{
    return age > 18
}

fun List<Student>.adultlistname():List<String>{
    return this.filter { it.age >  18 }.map { it.name }
}