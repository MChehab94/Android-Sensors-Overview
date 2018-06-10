package mchehab.com.java;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorsFragment sensorsFragment = new SensorsFragment();
        AccelerometerDataFragment accelerometerDataFragment = new AccelerometerDataFragment();

        List<Fragment> listFragments = Arrays.asList(sensorsFragment, accelerometerDataFragment);
        List<String> listTitles = Arrays.asList("Sensors", "Accelerometer Data");

        ViewPager viewPager = findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),
                listFragments, listTitles);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
