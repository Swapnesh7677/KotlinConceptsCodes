package com.swapnesh.myapplication.acceptanceTest

import com.swapnesh.myapplication.Testing.Car
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CarFeature {

    private val car = Car(6.0)
    @Test
    fun CarlooseFulewhenitTurnOn(){
        car.turnOn()

        assertEquals(5.5,car.fuel)
    }
}