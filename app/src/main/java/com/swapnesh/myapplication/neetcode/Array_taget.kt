package com.swapnesh.myapplication.neetcode

fun main(){

       val num = intArrayOf(2, 4, 3, 5, 7, 8, -1)
        val target = 7
        val output = mutableListOf<Pair<Int, Int>>()


        for (i in num.indices) {
            for (j in i + 1 until num.size) {
                if (num[i] + num[j] == target) {
                    output.add(Pair(num[i], num[j]))
                }
            }
        }

        println("Output: $output")







}




//it will give single only


fun twoSum(nums: IntArray, target: Int): IntArray {
    for (i in nums.indices) {
        for (j in i + 1 until nums.size) {
            if (nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}