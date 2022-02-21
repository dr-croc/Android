
public class MainActivity extends AppCompatActivity  {
    private Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // the button in on another page. By Pressing the button, the custom toast will be showed
        stop = findViewById(R.id.button);

        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = getLayoutInflater();

                //inflater.inflate(which layout to inflate, layout id);
                View customView = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.customToast));

                Toast toast = new Toast(MainActivity.this);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);

                // set which view you wanna show and then select the view
                toast.setView(customView);
                toast.show();
            }
        });


    }

}

/*

custom_toast_layout.xml

<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"     
    android:orientation="horizontal"
    
     android:id="@+id/customToast" 
    >

    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/plus"
        />

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="You have clicked the get out button"
        />

</LinearLayout>



*/
