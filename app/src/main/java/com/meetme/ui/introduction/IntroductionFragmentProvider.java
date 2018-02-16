package com.meetme.ui.introduction;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by user on 16.02.2018.
 */

@Module
public abstract class IntroductionFragmentProvider {

    @ContributesAndroidInjector(modules = IntroductionFragmentModule.class)
    abstract IntroductionFragment provideIntroductionFragmentFactory();
}
