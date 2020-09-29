package apssdc.in.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView nav_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nav_view = findViewById(R.id.bottomNavigationView);

        nav_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.red:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.linear_container,new RedFragment())
                                .commit();
                        break;
                    case R.id.green:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.linear_container,new GreenFragment())
                                .commit();
                        break;
                    case R.id.blue:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.linear_container,new BlueFragment())
                                .commit();
                        break;
                }
                return true;
            }
        });
    }
}