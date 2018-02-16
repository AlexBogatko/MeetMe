package com.meetme.ui.introduction;

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
}
