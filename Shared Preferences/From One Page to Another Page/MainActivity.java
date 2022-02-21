import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText edt_name;
    Button push;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        push = findViewById(R.id.goToResultActivity);
        edt_name = findViewById(R.id.edt_enterYourName);

        push.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                //get the value first
                String value = edt_name.getText().toString();

                // then use putExtra Method to send some more data to another page
                // putExtra("Key name", value);
                intent.putExtra("editValue",value);

                startActivity(intent);
            }
        });
    }
}

/*
activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical"
    android:gravity="center"
    >
    <EditText
        android:id="@+id/edt_enterYourName"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter your Name"

        />
    <Button
        android:id="@+id/goToResultActivity"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/edt_enterYourName"
        android:text="push"
        android:layout_marginStart="170dp"
        android:layout_marginTop="30dp"
        />
</RelativeLayout>
*/
