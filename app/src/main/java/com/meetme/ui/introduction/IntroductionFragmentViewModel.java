package com.meetme.ui.introduction;

import android.databinding.BindingAdapter;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.meetme.DataManager;
import com.meetme.ui.base.BaseViewModel;
import com.meetme.utils.rx.SchedulerProvider;

/**
 * Created by user on 16.02.2018.
 */

public class IntroductionFragmentViewModel extends BaseViewModel<IntroductionNavigator> {

    public IntroductionFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


    public ViewPager.OnPageChangeListener mOnPageChangeListener
            = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void openActivityNavigator(){
        getNavigator().openNextActivity();
    }
}
