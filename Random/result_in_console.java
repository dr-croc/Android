public class MainActivity extends AppCompatActivity {
    private Button logIn,logOut;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logIn = findViewById(R.id.button);
        logOut = findViewById(R.id.button2);
    }
    public void showMessage(View v)
    {
        if (v.getId() == R.id.button) {
            Log.d("tag","Log in button clicked");
        }
        if (v.getId() == R.id.button2) {
            Log.d("tag","Log out button clicked ");
        }

    }
}
