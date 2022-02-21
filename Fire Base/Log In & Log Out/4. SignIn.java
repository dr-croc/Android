import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText bt1, bt2;
    Button signUp;

    // here we want to check so, befor any operation get the firebase auth.
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bt1 = findViewById(R.id.login_edt_email);
        bt2 = findViewById(R.id.login_edt_password);
        signUp = findViewById(R.id.login_btn_singIn);

        // add the instances
        auth = FirebaseAuth.getInstance();

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  email = bt1.getText().toString();
                String password = bt2.getText().toString();
                loginUser(email, password);
            }
        });
    }
    private void loginUser(String email, String password) {

        // signInWithEmailAndPassword: will automatically take the value  to check
        auth.signInWithEmailAndPassword(email,password)

                //  addOnSuccessListener : if the value match it will take the user to home page
                // we could have add more value to check
                // but that something you can develop
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, Home.class));
                        finish();
                    }
                })
        ;
    }
}
