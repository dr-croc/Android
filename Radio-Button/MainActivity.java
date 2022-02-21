package com.example.widget;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    RadioButton choosen_RadioButton ;
    Button order_button;
    // using the radio group will give you access to all the button in the radio button
   RadioGroup radioGroup;
   TextView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        order_button = findViewById(R.id.order);
        radioGroup = findViewById(R.id.radioGroup); // for the whole radio group
        list = findViewById(R.id.list); // text to show what was selected

        order_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // this will return which item was selected in radio button
                int selectedId = radioGroup.getCheckedRadioButtonId();

              choosen_RadioButton= findViewById(selectedId);// get the radio button
              String value = choosen_RadioButton.getText().toString();// by that id get the text

                list.setText(value);
            }
        });

    }

}
