package com.swapnesh.myapplication.flows

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    /*What collectLatest Does
  It collects values like collect,but If a new value is emitted while you're still processing
     the previous one, it cancels the ongoing work and starts processing the new value.*/


    /*When to Use collectLatest?
    Use it when:

    You only care about the latest value.
    You want to cancel outdated work (e.g., UI updates, search queries).
    You’re dealing with rapid emissions and want to avoid unnecessary processing.*/

    runBlocking {


   /*     flow {
            emit(1)
            delay(100)
            emit(2)
            delay(100)
            emit(3)
            delay(100)
            emit(4)
            delay(100)
        }.collect { value ->
            println("Collecting $value")
            delay(300) // Simulate long processing
            println("Done with $value")
        }*/

       flow {
            emit(1)
            delay(100)
            emit(2)
            delay(100)
            emit(3)
            delay(100)
            emit(4)
            delay(100)
        }.collectLatest { value ->
            println("Collecting $value")
            delay(300) // Simulate long processing
            println("Done with $value")


        }
    }


    /*Search-as-you-type
    Imagine you're building a search feature in an Android app. As the user types, you want to:

    Send a search query to the server.
    Display results.
    Cancel the previous search if the user types a new character before the previous search finishes.*/




}

class LatestViewModel : ViewModel(){
    val queryFlow = MutableStateFlow("")

    fun observeSearch() {
        viewModelScope.launch {
            queryFlow
                .debounce(300) // Wait for user to pause typing
                .filter { it.isNotBlank() }
                .collectLatest { query ->
                    /*val results = searchApi.search(query) // suspend function
                    showResults(results)*/
                }
        }
    }


    /*What Happens Here:
    User types: "a" → "ap" → "app" quickly.
    collectLatest cancels the "a" and "ap" searches if "app" comes in before they finish.
    Only the latest query ("app") is processed*/
}