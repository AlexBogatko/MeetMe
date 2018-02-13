package com.meetme.ui.login;

/**
 * Created by amitshekhar on 08/07/17.
 */

public interface LoginNavigator {

    void openMainActivity();

    void handleError(Throwable throwable);

    void openIntroductionActivity();

    void login();

}
