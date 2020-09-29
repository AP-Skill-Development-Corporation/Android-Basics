package apssdc.in.tabsfornavigation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = findViewById(R.id.tablayout);
        viewpager = findViewById(R.id.viewpager);
        ViewPagerAdapter vpa = new ViewPagerAdapter(getSupportFragmentManager());
        viewpager.setAdapter(vpa);
        tabLayout.setupWithViewPager(viewpager);
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

        // To get the tab names, override the following method

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return "RED";
                case 1: return "GREEN";
                case 2: return "BLUE";
            }
            return super.getPageTitle(position);
        }
    }
}