package com.swapnesh.myapplication


import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

enum class CounterState {
    NotStarted, InProgress, Completed
}

suspend fun fetchIconFromNetwork(counterState: CounterState): ImageVector {
    // Simulate network delay
    delay(200)
    when (counterState) {
        CounterState.NotStarted -> return Icons.Filled.CheckCircle
        CounterState.InProgress -> return Icons.Filled.Person
        CounterState.Completed -> return Icons.Outlined.AccountCircle
    }

}

fun main(){
//    fun showToast(message: String) {
//        Toast.makeText(, message, Toast.LENGTH_SHORT).show()
//    }
}



suspend fun startCounter(
    increment: () -> Unit,
    onCounterEnded: () -> Unit
) {
    Log.i("Counter", "Starting Counter")
    delay(2000)
    for (i in 1..10) {
        delay(1000)
        increment()
    }
    onCounterEnded()
}

@Composable
fun MainScreen() {

    val context = LocalContext.current as ComponentActivity

    var counter by remember {
        mutableStateOf(0)
    }

    var counterMessage by remember {
        mutableStateOf("Counter not yet started")
    }

    val counterBackGroundColor by remember(counter) {
        derivedStateOf {
            if (counter % 2 == 0) Color.Green else Color.Red
        }
    }

    var increaseCounter = {
        counter++
        counterMessage = "Counter Increased to $counter"
    }

    Log.i("Counter", " Counter value $counter")

    var counterState by remember {
        mutableStateOf(CounterState.NotStarted)
    }

    SideEffect {

        when (counter) {
            0 -> {
                counterState = CounterState.NotStarted
            }
            10 -> {
                counterState = CounterState.Completed
            } else -> {
            counterState = CounterState.InProgress
        }
        }

        Log.i("SideEffect","SideEffect is getting invoked $counterState")
    }

    // As per the counter State -> Make an API call - > Fetch the icon -> render the icon

    DisposableEffect(key1 = Unit) {
        onDispose {
            Log.i("DisposableEffect","On Dispose getting invoked")
        }
    }



    Surface(
        //Aligns the content of this component along the specified [alignment] lines.
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(1.dp)
        ) {

            CounterMessage(counterMessage, context = context, increaseCounter = increaseCounter)
            DisplayNetworkIcon(counterState = counterState)
            Row(
                verticalAlignment = Alignment.CenterVertically,

                ) {

                Text(
                    text = "$counter", modifier = Modifier
                        .padding(20.dp)
                        .background(counterBackGroundColor)
                        .width(50.dp)
                        .height(50.dp),
                    textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                    fontSize = 35.sp
                )
            }

        }

    }
}

@Composable
fun CounterMessage(
    counterMessage: String,
    context: ComponentActivity,
    increaseCounter: () -> Unit
) {
    val counterMessageLatest by rememberUpdatedState(newValue = counterMessage)
    Log.i("Counter", " Rendering CounterMessage with $counterMessageLatest")
    LaunchedEffect(key1 = Unit) {
        Log.i("Counter", " LaunchedEffect with $counterMessageLatest")
        startCounter({ increaseCounter() }) {
            Log.i("Counter", "Counter Ended with $counterMessageLatest")
            //showToast("Counter Ended", context)
        }
    }
    Text(
        text = counterMessageLatest,
        fontSize = 20.sp,
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun DisplayNetworkIcon(counterState: CounterState) {
    val context = LocalContext.current

    val iconState = produceState<ImageVector?>(initialValue = null, counterState) {
        value = fetchIconFromNetwork(counterState)
    }

    // Display the icon if available, otherwise show a progress indicator
    Box(modifier = Modifier
        .width(40.dp)
        .height(40.dp), contentAlignment = Alignment.Center) {
        iconState.value?.let {
            Icon(imageVector = it, contentDescription = "Network fetched icon",
                modifier = Modifier.size(48.dp))
        } ?: CircularProgressIndicator()
    }
}


