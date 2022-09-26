package com.example.patternsinandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.patternsinandroid.Controller.controller

class MainActivity3 : AppCompatActivity() {

    lateinit var  txt: TextView
    lateinit var  btn: Button

    lateinit var controller_: controller
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        btn = findViewById(R.id.kt_3_btn_result)
        txt = findViewById(R.id.kt_3_txt_resut)

        controller_ = controller(this) //sending the referencce
        btn.setOnClickListener {
            // sending the value to the main controller
            controller_.suggestDrink()
        }
    }
}
