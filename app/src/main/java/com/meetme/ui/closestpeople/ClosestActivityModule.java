package com.meetme.ui.closestpeople;

import com.meetme.data.DataManager;
import com.meetme.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class ClosestActivityModule {

    @Provides
    ClosestMapViewModel provideClosestMapViewModel(DataManager dataManager,
                                         SchedulerProvider schedulerProvider) {
        return new ClosestMapViewModel(dataManager, schedulerProvider);
    }
}
