package com.swapnesh.myapplication

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.swapnesh.myapplication.compose.CounterApp
import com.swapnesh.myapplication.compose.MyviewModel
import com.swapnesh.myapplication.compose.Row_with_text_textfield
import com.swapnesh.myapplication.compose.Screen

import com.swapnesh.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {

    private val  viemmodel : MyviewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {






            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                  /*  Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )*/

                   // UserList(viewModel = UserViewModel())
                  //  OffsetScreen()

                   // TimerScreen()
                    //TimerScreen1()

                               // Screen(viemmodel)
                    //Row_with_text_textfield()
                    CounterApp()
                }
            }
        }
    }


}

@Composable
fun Greeting( modifier: Modifier = Modifier) {
   // var coffeeCount = 0   // This will not trigger UI updates

    //remember { mutableStateOf(0) } → Creates a state variable.
   // var coffeeCount by  remember { mutableIntStateOf(0) }

    //by allows direct access to value without coffeeCount.value
    //var coffeeCount = remember { mutableIntStateOf(0) }  //we can define like this also


    var coffeeCount by  rememberSaveable { mutableIntStateOf(0) }

    Counter(coffeeCount = coffeeCount, onIncrement = { coffeeCount++ })  // State hosting


}

@Composable
fun Counter(coffeeCount :Int,onIncrement:() -> Unit){
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text(
                text = "You've had ${coffeeCount} cups of coffee.",
                modifier = Modifier
                    .padding(16.dp)
            )
            Button(onClick = onIncrement) {
                Text(text = "Add")

            }
        }

    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting()
    }
}

@Composable
fun OffsetScreen(modifier: Modifier = Modifier) {

    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth(0.7f)
                .height(150.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Spacer(
                modifier = Modifier
                    .offset(x = 0.dp, y = -(50.dp)) // move the content to the top
                    .background(Color.Red, CircleShape)
                    .size(100.dp)
            )
        }
    }
}

//remember { mutableIntStateOf(0) }


/*val charPool: List<Char> = ('a'..'z') + ('A'..'Z')
val result = (1..7)

    .map { nextInt(0, charPool.size) }

    .map(charPool::get)

    .joinToString("")

print (res)

===
val setA = mutableSetOf(1, 2, 3, 3, 2, 1)

val setB = setOf(1, 2, 3, 1, 2, 3)

println("$setA and $setB")

println(setA == setB)
===*/
