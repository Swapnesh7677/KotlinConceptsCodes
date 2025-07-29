package com.swapnesh.myapplication

open class Password_unitTest {

    fun VaildPassword(input :String) {
        when{

            input.isBlank()->"Password is required"
            input.length < 6 -> "Password lenght should be more than 6"
            input.length >15 -> "Password lenght should be not more than 15"
            else -> "valid"

        }
    }
}