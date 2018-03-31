package com.meetme.ui.introduction;

import com.meetme.DataManager;
import com.meetme.ui.base.BaseViewModel;
import com.meetme.utils.rx.SchedulerProvider;

/**
 * Created by user on 13.02.2018.
 */

public class IntroductionViewModel extends BaseViewModel<IntroductionNavigator> {

    public int onPageSelected;

    public IntroductionViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void onClick(){

    }

    public void leftBottomClicked(){

    }

    public void rightBottomClicked(){
        getNavigator().requestPermission();
    }
}
