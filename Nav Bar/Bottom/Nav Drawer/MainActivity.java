import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  implements  NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        drawerLayout = findViewById(R.id.nav_view);
       Toolbar toolbar = findViewById(R.id.toolBar);
       ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.navigation_draw_open, // see in string.xml
                R.string.navigation_draw_close); // see in string.xml
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // set the default fragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, new Home()).commit();

        if(savedInstanceState ==null)
        {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, new Home()).commit();
            navigationView.setCheckedItem(R.id.home);
        }

    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId())
        {
            case R.id.home:
                getSupportFragmentManager()
                        .beginTransaction().
                        replace(R.id.fragmentContainer, new Home()).commit();
                break;
            case R.id.camera:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragmentContainer, new Camera()).commit();
                break;
            case R.id.message:
                startActivity(new Intent(this, MainActivity2.class));

        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

}
