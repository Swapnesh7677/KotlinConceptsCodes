package com.swapnesh.myapplication.compose

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf

@Composable
fun CounterApp(){
    var counter by remember { mutableStateOf(0) }
    CounterDisplay(counter , onIncerment={ counter++})
}

@Composable
fun CounterDisplay(counter:Int, onIncerment: () -> Unit){
    Button(onClick = onIncerment) {
        Text(text="Count :--->${counter}")
    }
}