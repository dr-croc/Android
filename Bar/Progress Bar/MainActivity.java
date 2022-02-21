import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    int progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById( R.id.progreesBarId);

        Thread thread = new Thread(new Runnable() { // to change the value of progress bar over time
            @Override
            public void run() {
                doWork();
                // if you want to go antoher actvity after the progress bar reaach the end
                // just start an activity after this doWork();
                // it will automatically take you to another activity.
            }
        });
        thread.start();  // you have to start the thread to make it work
    }

    public void doWork()  { // we will change the value of the progress bar in this do work method
        for(progress = 10; progress<=100; progress=progress+10)
        {
            try {
                // 1000 means 1 second
                // which means after one second the value of the progress bar will change
                Thread.sleep(1000);
                progressBar.setProgress(progress);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


/*
____________________________________ activityMain.xml_________________________________
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
    <ProgressBar
        android:id="@+id/progreesBarId"
        style="@android:style/Widget.ProgressBar.Horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:progressTint="#9A8D1A"
        android:progressBackgroundTint="#EF920A"
        />
</LinearLayout>
*/
