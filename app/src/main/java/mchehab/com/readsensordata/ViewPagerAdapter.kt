package mchehab.com.readsensordata

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class ViewPagerAdapter(fragmentManager: FragmentManager, val listFragments: List<Fragment>, val
listTitles: List<String>) :
        FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return listFragments[position]
    }

    override fun getCount(): Int {
        return listFragments.count()
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return listTitles[position]
    }
}