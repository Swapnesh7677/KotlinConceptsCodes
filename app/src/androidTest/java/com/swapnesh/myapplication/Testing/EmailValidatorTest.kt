package com.swapnesh.myapplication.Testing

import com.swapnesh.myapplication.Password_unitTest
import junit.framework.TestCase.assertEquals
import org.junit.BeforeClass
import org.junit.Test


class EmailValidatorTest {

    @Test
    fun validateEmail_ReturnTrue(){
        val emailValidator = EmailValidator()
       // val email = "test@example.com"
        val email = "user.name+tag+sorting@example.com"
        assertEquals(true,emailValidator.isValidEmail(email))
    }


    @Test
    fun validateEmail_RetrunFalse(){
        val emailValidator = EmailValidator()
        val email = "test@example.com"
        //  val email = "user_name@example.co.in"
        // val email = "user-name@domain.org"

        assertEquals(true,emailValidator.isValidEmail(email))
    }

}