package com.meetme.di;

import com.meetme.ui.introduction.IntroductionActivity;
import com.meetme.ui.introduction.IntroductionActivityModule;
import com.meetme.ui.introduction.IntroductionFragmentProvider;
import com.meetme.ui.login.LoginActivity;
import com.meetme.ui.login.LoginActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by user on 12.02.2018.
 */

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = LoginActivityModule.class)
    abstract LoginActivity bindLoginActivity();

    @ContributesAndroidInjector(modules = {IntroductionActivityModule.class,
            IntroductionFragmentProvider.class})
    abstract IntroductionActivity bindIntroductionActivity();
}
