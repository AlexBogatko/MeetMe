package com.meetme.ui.login;

import com.meetme.data.DataManager;
import com.meetme.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

/**
 * Created by amitshekhar on 14/09/17.
 */
@Module
public class LoginActivityModule {

    @Provides
    LoginViewModel provideLoginViewModel(DataManager dataManager,
                                         SchedulerProvider schedulerProvider) {
        return new LoginViewModel(dataManager, schedulerProvider);
    }

}
