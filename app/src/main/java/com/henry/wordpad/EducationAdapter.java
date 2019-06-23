package com.henry.wordpad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class EducationAdapter extends FragmentPagerAdapter {

    private String[] title = new String[]{"国内","国外"};

    public EducationAdapter(FragmentManager manager){
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new EducationFirstFragment();
        }else{
            return new EducationSecondFragment();
        }
    }


    @Override
    public CharSequence getPageTitle(int position){
        return title[position];
    }
    @Override
    public int getCount() {
        return 2;
    }
}
