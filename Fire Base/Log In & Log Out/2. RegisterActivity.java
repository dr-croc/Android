import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText bt1, bt2;
    Button signUp;

    // to begin with you have get the firebase auth
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        bt1 = findViewById(R.id.register_edt_email);
        bt2 = findViewById(R.id.register_edt_password);
        signUp = findViewById(R.id.register_btn_singup);

        // initializing the auth...............................................
        firebaseAuth = FirebaseAuth.getInstance();
        //....................................................................

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  email = bt1.getText().toString();
                String password = bt2.getText().toString();

                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password))
                {
                    Toast.makeText(RegisterActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }

                else if(password.length()<6)
                {
                    Toast.makeText(RegisterActivity.this, "Password too short", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    registerUser(email, password);
                }
            }
        });
    }

    private void registerUser(String email, String password) {

        // this  createUserWithEmailAndPassword method will take the value and an user in the firebase database
        firebaseAuth.createUserWithEmailAndPassword(email, password)

                // addOnCompleteListener : if successfully the value added we are adding a listener to check
                .addOnCompleteListener( RegisterActivity.this ,new OnCompleteListener<AuthResult>() {

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful())
                        {
                            Toast.makeText(RegisterActivity.this, "Task Successful", Toast.LENGTH_SHORT).show();
                            startActivity( new Intent(RegisterActivity.this, Home.class));
                            finish();
                        }

                        else
                        {
                            Toast.makeText(RegisterActivity.this, "Failed Registration", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}
