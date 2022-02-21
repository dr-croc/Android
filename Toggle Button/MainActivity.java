public class MainActivity extends AppCompatActivity {
    ToggleButton tg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tg = findViewById(R.id.toggleButton);

        tg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder result = new StringBuilder();
                result.append("Toggle Button : ").append(tg.getText());
                if(result.toString().equals("On"))
                {
                    Toast.makeText(getApplicationContext(), "On", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Turned off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

/*

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <ToggleButton
        android:id="@+id/toggleButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textOff="Off"
        android:textOn="On "
        />
</LinearLayout>


*/
