package com.meetme.ui.introduction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.meetme.ui.introduction.fragments.IntroductionFragment;

/**
 * Created by user on 15.02.2018.
 */

public class IntroductionPagerAdapter extends FragmentStatePagerAdapter {

    private int mTabCount;

    public IntroductionPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return IntroductionFragment.newInstance(0);
            case 1:
                return IntroductionFragment.newInstance(1);
            case 2:
                return IntroductionFragment.newInstance(2);
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }

    public void setCount(int count) {
        mTabCount = count;
    }

}
