package com.meetme.ui.introduction;

import android.util.Log;

import com.meetme.DataManager;
import com.meetme.ui.base.BaseViewModel;
import com.meetme.utils.rx.SchedulerProvider;

/**
 * Created by user on 13.02.2018.
 */

public class IntroductionViewModel extends BaseViewModel<IntroductionNavigator> {

    public IntroductionViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }

    public void textViewClicked(){
//        Toast.makeText(get, "asdsa", Toast.LENGTH_SHORT).show();
        Log.i("ASD", "asdasdasdasd");
    }
}
