package com.swapnesh

import android.os.SystemClock
import com.swapnesh.myapplication.MainActivity
import com.swapnesh.myapplication.Password_unitTest
import io.mockk.mockkStatic
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


class valiadatepassword {




    @Test
    fun validatepass_bankinput_expectFluse(){


        val pass = Password_unitTest()
        val result= pass.VaildPassword("")
        Assert.assertEquals("Password is required",result)
    }
    @Test
    fun validatepass_2chinput_expectFluse(){
        val pass = Password_unitTest()
        val result= pass.VaildPassword("an")
        Assert.assertEquals("Password lenght should be more than 6",result)
    }
    @Test
    fun validatepass(){
        val pass = Password_unitTest()
        val result= pass.VaildPassword("andshashl")
        Assert.assertEquals("Valid",result)
    }
}