import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    
    private TextView textView;
    private DatePickerDialog datePickerDialog;
    private Button button;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtId);
        button = findViewById(R.id.button);

        DatePicker datePicker = new DatePicker(this);

        // get the current day, month, year
        int currentYear = datePicker.getYear();
        int currentMonth=  datePicker.getMonth();
        int currentDay = datePicker.getDayOfMonth();
        //textView.setText(currentDay+" : "+currentMonth+" : "+currentYear );
        
        button.setOnClickListener(new View.OnClickListener() { // this button will open the date picker to pick the date.
            @Override
            public void onClick(View v) {
                
                datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                textView.setText(dayOfMonth+" / "+month+" / "+year);
                            }

                        }, currentYear, currentMonth, currentDay);
                datePickerDialog.show();
            }
        });
    }
}

/*
_________________________________________activity_main.xml_______________________________________

<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="20dp"
    android:orientation="vertical"
    >
    <TextView
        android:id="@+id/txtId"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Current Date :"
        android:textSize="20sp"
        android:textStyle="bold"
        android:textAllCaps="false"
        android:layout_gravity="center_horizontal"
        />
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Show DatePicaker Dialog"
        android:textAllCaps="false"
        android:layout_marginTop="10dp"
        android:layout_gravity="center_horizontal"
        />
</LinearLayout>
*/
