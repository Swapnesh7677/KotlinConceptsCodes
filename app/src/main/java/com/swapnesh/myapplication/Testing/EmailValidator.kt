package com.swapnesh.myapplication.Testing

import android.util.Patterns


open class EmailValidator {

    fun isValidEmail(email:String):Boolean{

        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}