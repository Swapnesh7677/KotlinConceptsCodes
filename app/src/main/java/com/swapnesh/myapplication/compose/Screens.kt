package com.swapnesh.myapplication.compose

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random


@SuppressLint("SuspiciousIndentation")
@Composable
fun Screen(vw : MyviewModel){
    var textfieldv by remember { mutableStateOf("") }

    var  random by vw.statevale

        Row(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround


        ){
           Text(text = random)
           TextField(value = textfieldv,
               onValueChange = {
                    textfieldv = it
               })
        }

}



class MyviewModel():ViewModel(){

    private val _statevalue = mutableStateOf("")
    var statevale: MutableState<String> = _statevalue

    init {

        _statevalue.value = Random.nextInt().toString()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun Row_with_text_textfield(){

    var context = LocalContext.current

    //var count by remember { mutableStateOf(0) }
    var count by rememberSaveable  { mutableStateOf(0) }

    val scope =  rememberCoroutineScope()

  /*  Scaffold(topBar = {
        Text(text = "Home Screen")
        BottomAppBar { Text(text = "save")}
        FloatingActionButton(onClick = {
        }){
            Text(text = "Add")
        }

    }) {}*/


        Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround){

            Text(text = count.toString())
            Button(onClick = {
                count++
                /*scope.launch {
                  var result = performClickDelay()
                    if(result){
                        count++
                    }
                }*/


            }) { Text(text = "Increment") }
        }


       /* SideEffect {
            Toast.makeText(context,"sideefeect--->${count}",Toast.LENGTH_SHORT).show()
        }*/

    LaunchedEffect(count) {
        Toast.makeText(context,"LaunchedEffect--->${count}",Toast.LENGTH_SHORT).show()
    }


}


suspend fun performClickDelay():Boolean{

    delay(4000)
    return true

}


val LocalColors = staticCompositionLocalOf {
    MyThemeColor(
        primary = Color.Blue,
        secondary = Color.Green,
        Background = Color.Cyan,
    )
}

