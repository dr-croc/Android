import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView  = findViewById(R.id.navMenu);
        bottomNavigationView.setOnNavigationItemSelectedListener(navigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new Home()).commit();// here you have to give the id main activity fragment container and a default fragment to show
    }
    
    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectedFragment = null;
            switch (item.getItemId())
            {
                case R.id.item_1:
                    selectedFragment = new Home();
                    break;
                case R.id.item_2:
                    selectedFragment = new Move();
                    break;
                case R.id.item_3:
                    selectedFragment = new User();
                    break;
                case R.id.item_4:
                    selectedFragment = new Camera();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit();
            return true;
        }
    };
}
