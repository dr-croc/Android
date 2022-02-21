import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    private SeekBar seekBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.result);


        textView.setText("Volume : "+ seekBar.getProgress()+" / "+seekBar.getMax()); // seekBar.getProgress() : gives the value at certain point
        //seekBar.getMax() : Gives the max value

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) { // while we are touching the seekbar
                textView.setText("Volume : "+ progress+" / "+seekBar.getMax());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { // when we first touch the seek bar
                Toast.makeText(MainActivity.this, " Start", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { // when we stop
                Toast.makeText(MainActivity.this, "Stop", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

/* 

________________________________________________________activity_main.xml______________________________
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="20dp"
    android:orientation="vertical"
    >
    <SeekBar
        android:id="@+id/seekBar"
        android:layout_width="200dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:max="20"
        android:thumbTint="#8834ceed"
        />
    <TextView
        android:id="@+id/result"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="20sp"
        android:layout_gravity="center_horizontal"

        />
</LinearLayout>
*/
