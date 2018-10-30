package com.xinkao.xinkao.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Author by 钱,Date on 2018/10/30 0030.
 * PS:Not easy to write code,please indicate.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    List<Fragment> fragments;
    public MainPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
