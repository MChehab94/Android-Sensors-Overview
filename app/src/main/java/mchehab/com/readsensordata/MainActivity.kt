package mchehab.com.readsensordata

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sensorsFragment = SensorsFragment()
        val sensorDataFragment = AccelerometerDataFragment()
        val listFragments = listOf(sensorsFragment, sensorDataFragment)
        val listTitles = listOf("Sensors", "Accelerometer Data")
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, listFragments, listTitles)
        viewPager.adapter = viewPagerAdapter
        tabLayout.setupWithViewPager(viewPager)
    }
}