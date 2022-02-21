public class MainActivity extends AppCompatActivity  {
    private Switch sw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sw = findViewById(R.id.switc);

        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked == true)
                {
                    Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
