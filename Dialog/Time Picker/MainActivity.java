import androidx.appcompat.app.AppCompatActivity;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    
    private TextView textView;
    private Button button;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtId);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TimePicker timePicker = new TimePicker(MainActivity.this);

                // get the current time
                int currentHour = timePicker.getCurrentHour();
                int currentMinute = timePicker.getCurrentMinute();

                timePickerDialog = new TimePickerDialog(MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                textView.setText(hourOfDay+" : "+minute);
                            }
                        }, currentHour, currentMinute, false);
                timePickerDialog.show();
            }
        });
    }
}
/*

_____________________________________activity_main.xml___________________

 <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="10dp"
    android:orientation="vertical">
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show  Time Picker"
        android:textAllCaps="false"
        android:layout_marginTop="10dp"
        android:layout_gravity="center_horizontal"
        />
    <TextView
        android:id="@+id/txtId"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:textSize="20sp"
        android:layout_marginTop="20dp"
        />
</LinearLayout>
*/
