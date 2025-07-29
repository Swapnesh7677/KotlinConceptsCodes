package com.swapnesh.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

sealed class  UiState<out T>{
    data class  Success<out T>(val data:T): UiState<T>()
    data class Error(val message:String) : UiState<Nothing>()
     object Loading :UiState<Nothing>()

}

class UserViewModel : ViewModel(){

    private val _Uistate = MutableStateFlow<UiState<List<String>>>(UiState.Loading)
    val uiState : StateFlow<UiState<List<String>>> = _Uistate
    init {
        FetchUers()
    }

    fun FetchUers(){
        viewModelScope.launch {
            _Uistate.value = UiState.Loading
            delay(5000)

            val users = listOf("Alice","Sager","Bob","Jorge","Rahul")

            _Uistate.value = UiState.Success(users)


            //_Uistate.value = UiState.Error("Error fetching data")


        }
    }
}


@Composable
fun UserList(viewModel: UserViewModel){


    val uiState  by viewModel.uiState.collectAsState()

    when(uiState){

        is UiState.Loading -> CircularProgressIndicator()

        is UiState.Success -> {
                        //uiState.data add then solve using error
            val users = (uiState as UiState.Success<List<String>>).data

            LazyColumn {
                items(users){users->
                    Text(text = users, modifier = Modifier.padding(18.dp))

                }
            }
        }

        is UiState.Error -> {
            val errorMessage = (uiState as UiState.Error).message
            Text(text = "Error: $errorMessage", color = Color.Magenta)
        }
    }


}


