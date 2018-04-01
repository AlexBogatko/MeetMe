package com.meetme.ui.introduction.fragments;

import com.meetme.data.DataManager;
import com.meetme.ui.base.BaseViewModel;
import com.meetme.ui.introduction.IntroductionNavigator;
import com.meetme.utils.rx.SchedulerProvider;

/**
 * Created by user on 16.02.2018.
 */

public class IntroductionFragmentViewModel extends BaseViewModel<IntroductionNavigator> {

    public IntroductionFragmentViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void openActivityNavigator(){
        getNavigator().openNextActivity();
    }
}
