// this list view can be used if you have one data to show
public class MainActivity extends AppCompatActivity {
  
String[] word ={"a","b","c","d","e","f","g","h"};
Integer[] image = {R.mipmap.ic_launcher};

ListView listView;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.am1_listView);

    ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, word );

    listView.setAdapter(adapter);
    }
}


/*
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:padding="10dp"
    >

    <ListView
        android:id="@+id/am1_listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        />
</LinearLayout>

*/
