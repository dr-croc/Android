package com.example.patternsinandroid.Controller


import com.example.patternsinandroid.MainActivity3
import com.example.patternsinandroid.model.DrinksModel_

class controller {

    lateinit var model: DrinksModel_ // taking reference to our model
    lateinit var  mainActivity3: MainActivity3

    constructor(mainActivity_3: MainActivity3) {
        this.mainActivity3 = mainActivity_3
        model = DrinksModel_(this)
    }

    fun suggestDrink() {
        model.suggestDrink()
    }

    // controller have two task also :
    // 1. Sending signal to model to perform the business logic.
    // 2. receiving the result from the model to execute and update the ui as well


    // performing task 2 which is recieving data from model
    fun onDrinkSuggested(drink_name: String){
        this.mainActivity3.txt.setText(drink_name)
    }
}
