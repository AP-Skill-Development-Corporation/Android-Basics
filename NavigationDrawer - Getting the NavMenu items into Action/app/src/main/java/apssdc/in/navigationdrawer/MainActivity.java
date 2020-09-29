package apssdc.in.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawerlayout);
        NavigationView navigation = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle =
                new ActionBarDrawerToggle(
                        this,
                        drawerLayout,
                        toolbar,
                        R.string.input,
                        R.string.output
                );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.red:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.linearlayout,new RedFragment())
                                .commit();
                        break;
                    case R.id.green:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.linearlayout,new GreenFragment())
                                .commit();
                        break;
                    case R.id.blue:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.linearlayout, new BlueFragment())
                                .commit();
                        break;
                    case R.id.dummy1:
                        Toast.makeText(MainActivity.this, "DUMMY 1 OPTION IS SELECTED", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.dummy2:
                        Toast.makeText(MainActivity.this, "DUMMY 2 OPTION IS SELECTED", Toast.LENGTH_SHORT).show();
                        break;
                }
                drawerLayout.closeDrawers();
                return true;
            }
        });
    }
}