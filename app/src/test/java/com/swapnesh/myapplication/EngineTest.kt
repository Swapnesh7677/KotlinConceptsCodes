package com.swapnesh.myapplication

import com.swapnesh.myapplication.Testing.Engine
import junit.framework.TestCase.assertEquals
import org.junit.Test

class EngineTest {

    private val engine = Engine(2000,189, 15, false)

    @Test
    fun engineTurnOnTest(){
        engine.turnOn()

        assertEquals(true,engine.isturnedOn)

        assertEquals(95,engine.temp)
    }

    @Test
    fun engineTurnOffTest(){
        engine.turnOn()
        engine.turnedOff()

        assertEquals(false , engine.isturnedOn)
        assertEquals(15,engine.temp)
    }
}