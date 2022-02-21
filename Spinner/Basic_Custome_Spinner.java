package com.example.widget;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    String[] friends= {"america", "arab", "logan","dhaka", "bangladesh"};
    private Spinner spinner;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinnerId);
        spinner = findViewById(R.id.spinnerId);
        textView = findViewById(R.id.textViewMainActivity);
        button = findViewById(R.id.printButton);

        // to set data in spinner
        // adapter change a  xml file to a view
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.sample_view, R.id.textViewSampleView,friends);
        spinner.setAdapter(adapter);

        // button just here to print the value
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value  = spinner.getSelectedItem().toString();// to get the selected item from spinner
                textView.setText(value);
            }
        });
    }

}

/*

___________________activity_main.xml________________________________

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="10dp"
    android:orientation="vertical"
    android:gravity="center"
    >
    <Spinner
        android:id="@+id/spinnerId"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        >
    </Spinner>
    <Button
        android:id="@+id/printButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Print"
        android:textSize="20sp"
        />
    <TextView
        android:id="@+id/textViewMainActivity"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="30sp"
        />
</LinearLayout>

____________________________sample_view.xml________________________________

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <TextView
        android:id="@+id/textViewSampleView"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:text="hello there"
        android:textSize="20sp"
        android:textStyle="bold"
        android:paddingLeft="10dp"
        android:background="#EDEDED"
        />
</LinearLayout>
*/
