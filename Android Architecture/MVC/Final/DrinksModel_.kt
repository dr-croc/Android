package com.example.patternsinandroid.model

import com.example.patternsinandroid.Controller.controller
import java.util.*

// this is a model class where we perform the business logic for our model
// also get the data from data base
// here we will have the business logic and it perform the business logics
// and send the result back to Controller to update the UI with the result

class DrinksModel_ {

    var drinkList = arrayOf(
        "Mint Margarita",
        "Spiking Coffee",
        "Sweet Bananas",
        "Tomato Tang",
        "Apple Berry Smoothie Pie"
    )

    // we will implement two task here,
    //          1. performing the business logic
    //          2. Send result back to controller (in order to send the result back to controller , we need to have a reference of the controller)

    // 1. performing the business logic here and sending the data to another function for sending it back to controller
    fun suggestDrink()
    {
        val drinkName = arrayOf("")
        drinkName[0] = drinkList[Random().nextInt(drinkList.size)]
        sendResultToController(drinkName[0]); // sending the it to next task
    }

    
    // performing 2nd task here
   lateinit var  controller_1: controller
   constructor(controller_variable: controller){
       this.controller_1 = controller_variable
    }
    // now send back result from our model to the controller
    private fun sendResultToController(drink_name: String) {
        controller_1.onDrinkSuggested(drink_name)
    }

}
