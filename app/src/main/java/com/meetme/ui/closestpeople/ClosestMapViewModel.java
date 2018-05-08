package com.meetme.ui.closestpeople;

import com.meetme.data.DataManager;
import com.meetme.ui.base.BaseViewModel;
import com.meetme.ui.login.LoginNavigator;
import com.meetme.utils.rx.SchedulerProvider;

public class ClosestMapViewModel extends BaseViewModel<ClosestNavigator> {

    public ClosestMapViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }


}
