package com.swapnesh.myapplication

fun main(){
        //Pair
   val(comapny, year1) = pairdemo()
    println(comapny)
    println(year1)

    val vaeriabel = "sagar"
    val age = 32

    val pairdata = Pair(vaeriabel,age)

    println(pairdata)

    // Triple
    val(company, year, empolyee) = tripleDemo()
    println(company)
    println(year)
    println(empolyee)


}


fun pairdemo():Pair<String, Int>{
    val company = "Capgemini"
    val year   = 1967
    return Pair(company,year)
}


fun tripleDemo() : Triple<String, Int, Int>{
    val company = "Capgemini"
    val year = 1967
    val empolyee = 2340000
    return Triple(company,year,empolyee)
}