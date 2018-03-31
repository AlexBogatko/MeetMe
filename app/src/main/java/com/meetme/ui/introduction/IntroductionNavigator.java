package com.meetme.ui.introduction;

/**
 * Created by user on 13.02.2018.
 */

public interface IntroductionNavigator {

    void openNextActivity();

    void setIsLoading();

    void setNotLoading();

    void requestPermission();
}
