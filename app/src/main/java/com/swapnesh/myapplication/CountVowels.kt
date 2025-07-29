package com.swapnesh.myapplication

fun countVowelsAndConsonants(input: String): Pair<Int, Int> {
    val vowels = "aeiouAEIOU"
    var vowelCount = 0
    var consonantCount = 0

    for (char in input) {
        when {
            char in vowels -> vowelCount++
            char.isLetter() -> consonantCount++
        }
    }

    return Pair(vowelCount, consonantCount)

}



fun filterAndSortDescending(numbers: List<Int>): List<Int> {
    return numbers.filter { it % 2 == 0 } // Remove odd numbers
     .sortedDescending() // Sort in descending order
}


fun main() {
   // val input = "Hello, World!"
    val input = "Swapnesh Khachane"
    val (vowels, consonants) = countVowelsAndConsonants(input)
    println("Vowels: $vowels, Consonants: $consonants")


    val list:List<Int> = listOf(12,43,65,33,98,9,23,56,88)
    println(filterAndSortDescending(list))



}
