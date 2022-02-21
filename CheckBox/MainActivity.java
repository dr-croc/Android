package com.example.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CheckBox ch1, ch2, ch3;
    TextView ordered_list;
    Button order_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find All the item in the check box one by one
        ch1 = findViewById(R.id.checked_coffee);
        ch2= findViewById(R.id.checked_tea);
        ch3 = findViewById(R.id.checked_Lemonade);

        order_button = findViewById(R.id.order);

        ordered_list = findViewById(R.id.list);

       order_button.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        int totalAmount = 0;

        if(view.getId() == R.id.order)
        {
            // this will ad all the values of  one by one
            // its a good way to make a list as the user proceed to order more things
            StringBuilder total_order = new StringBuilder();

            total_order.append("Selected Items :");

            // dont't use else if . So that you get all the items that is checked.
            if (ch1.isChecked()) {
                total_order.append("\n Coffee 100Rs"); // will be added to the total
                totalAmount += 100;
            }
             if (ch2.isChecked())
            {
                total_order.append("\n Tea 50Rs");// will be added to the total
                totalAmount+=50;
            }
             if (ch3.isChecked())
            {
                total_order.append("\n Lemonade 150Rs");// will be added to the total
                totalAmount+=150;
            }

            total_order.append("\n Total :"+totalAmount+" Rs");// total

            ordered_list.setText(total_order); // shown in the text view
        }

    }
}
