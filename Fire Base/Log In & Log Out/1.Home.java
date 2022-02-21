import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bt1, bt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bt1 = findViewById(R.id.register);
        bt2 = findViewById(R.id.signup);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class));

                // if the user hit the back button and it distroy or get you out of the app
                finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this, LoginActivity.class));

                // if the user hit the back button and it distroy or get you out of the app
                finish();
            }
        });
    }
     // to avoid log in each and every time we enter the  app
    @Override
    protected void onStart() {
        super.onStart();
        FireBaseUser  user = FirebaseAuth.getInstance().getCurrentUser();
        
    if(user != null)
        {
            startActivity(new Intent(MainActivity.this, give the activituy you want to go).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
        
    }
}
