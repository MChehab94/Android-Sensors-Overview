package mchehab.com.java;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> listFragment;
    private List<String> listTitles;

    public ViewPagerAdapter(FragmentManager fragmentManager, List<Fragment> listFragments,
                            List<String> listTitles){
        super(fragmentManager);
        this.listFragment = listFragments;
        this.listTitles = listTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return listFragment.get(position);
    }

    @Override
    public int getCount() {
        return listFragment.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }
}
