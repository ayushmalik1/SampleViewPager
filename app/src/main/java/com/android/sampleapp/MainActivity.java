package com.android.sampleapp;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String[] tabTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        tabLayout = findViewById(R.id.sample_tl);
        viewPager = findViewById(R.id.sample_vp);
        viewPager.setOffscreenPageLimit(6);
        tabTitles = getResources().getStringArray(R.array.tab_titles);
        setAdapter();
    }

    private void setAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabTitles.length; i++) {
            ((ViewGroup) (tabLayout.getChildAt(0))).getChildAt(i).setAlpha(0.5f);
        }
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("page", "position:" + position + " offset" + positionOffset + " pixels" + positionOffsetPixels);
                animateTab(position, 1f - positionOffset);
                if (position != ((ViewGroup) (tabLayout.getChildAt(0))).getChildCount() - 1) {
                    animateTab(position + 1, positionOffset);
                }

            }

            private void animateTab(int position, float fraction) {
                View tab = ((ViewGroup) (tabLayout.getChildAt(0))).getChildAt(position);
                float scale = 0.5f + fraction;
                tab.setAlpha(scale);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("page", "selected position:" + position + " offset");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
