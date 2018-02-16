package com.meetme.ui.introduction;

import android.arch.lifecycle.ViewModelProvider;

import com.meetme.DataManager;
import com.meetme.ViewModelProviderFactory;
import com.meetme.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 16.02.2018.
 */

@Module
public class IntroductionFragmentModule {

    @Provides
    IntroductionFragmentViewModel introductionFragmentViewModel(DataManager dataManager,
                                SchedulerProvider schedulerProvider) {
        return new IntroductionFragmentViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ViewModelProvider.Factory provideIntroductionFragmentViewModel(IntroductionFragmentViewModel introductionFragmentViewModel) {
        return new ViewModelProviderFactory<>(introductionFragmentViewModel);
    }
}