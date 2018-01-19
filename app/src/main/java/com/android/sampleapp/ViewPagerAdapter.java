package com.android.sampleapp;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by ayush on 19/1/18.
 */

class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private final String[] tabTitles;

    public ViewPagerAdapter(FragmentManager fragmentManager, Context context) {
        super(fragmentManager);
        tabTitles = context.getResources().getStringArray(R.array.tab_titles);

    }

    @Override
    public Fragment getItem(int position) {
        return SampleFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }



}
