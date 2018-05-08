package com.meetme.ui.login;

public interface LoginNavigator {

    void openMainActivity();

    void handleError(Throwable throwable);

    void openIntroductionActivity();

    void login();

}
