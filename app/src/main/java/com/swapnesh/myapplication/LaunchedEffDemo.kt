package com.swapnesh.myapplication


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import java.util.Timer
import kotlin.system.measureTimeMillis


@Composable
fun TimerScreen() {
    LaunchedEffect(key1 = Unit, block = {
        try {
            startTimer(10000L) {
                println("Timer ended")
            }
        } catch(ex: Exception) {
            println("timer cancelled")
        }
    })
}

@Composable
fun Timer(timerDuration: Long) {
    LaunchedEffect(key1 = timerDuration, block = {
        try {
            startTimer(timerDuration) {
                println("Timer ended")
            }
        } catch (ex: Exception) {
            println("timer cancelled")
        }
    })
}

suspend fun startTimer( time: Long, onTimerEnd: () -> Unit) {

    var nTime  = time
    println(nTime)
    while (nTime > 0) {
        delay(1000)
        nTime -= 1000L
        println(nTime)

    }

    onTimerEnd()
}


@Composable
fun TimerScreen1() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var timerDuration by remember {
            mutableStateOf(10000L) // default value = 1 sec
        }
        Button({
            timerDuration += 2000
        }) {
            Text("+2 second")
        }
        Text(timerDuration.toString())

        Timer(timerDuration = timerDuration)
    }
}