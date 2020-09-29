package apssdc.in.tabsfornavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewpager = findViewById(R.id.viewpager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(vpa);

    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter{

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return new RedFragment();
                case 1: return new GreenFragment();
                case 2: return new BlueFragment();
            }
            return null;
        }

        // The following method helps the viewpager understand
        // about how many total fragments are there to display on the
        // ViewPager
        @Override
        public int getCount() {
            return 3;
        }
    }
}