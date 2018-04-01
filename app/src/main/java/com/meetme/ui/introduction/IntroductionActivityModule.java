package com.meetme.ui.introduction;

import com.meetme.data.DataManager;
import com.meetme.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 13.02.2018.
 */

@Module
public class IntroductionActivityModule {

    @Provides
    IntroductionViewModel provideIntroductionViewModel(DataManager dataManager,
                                         SchedulerProvider schedulerProvider) {
        return new IntroductionViewModel(dataManager, schedulerProvider);
    }

    @Provides
    IntroductionPagerAdapter provideIntroductionPagerAdapter(IntroductionActivity activity) {
        return new IntroductionPagerAdapter(activity.getSupportFragmentManager());
    }
}
