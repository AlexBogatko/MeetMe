package com.meetme.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.meetme.BR;
import com.meetme.R;
import com.meetme.databinding.ActivityLoginBinding;
import com.meetme.ui.base.BaseActivity;
import com.meetme.ui.introduction.IntroductionActivity;

import javax.inject.Inject;

/**
 * Created by alex on 12/02/18.
 */

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> implements LoginNavigator {

    @Inject
    LoginViewModel mLoginViewModel;

    ActivityLoginBinding mActivityLoginBinding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityLoginBinding = getViewDataBinding();
        mLoginViewModel.setNavigator(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void openMainActivity() {
        startActivity(IntroductionActivity.getStartIntent(this));
//        Intent intent = MainActivity.getStartIntent(LoginActivity.this);
//        startActivity(intent);
//        finish();
    }

    @Override
    public void handleError(Throwable throwable) {
        // handle error
    }

    @Override
    public void openIntroductionActivity() {
        Intent intent = IntroductionActivity.getStartIntent(LoginActivity.this);
        startActivity(intent);
        finish();
    }

    @Override
    public void login() {
        String email = mActivityLoginBinding.etEmail.getText().toString();
        String password = mActivityLoginBinding.etPassword.getText().toString();
        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
            hideKeyboard();
            mLoginViewModel.login(email, password);
        } else {
            Toast.makeText(this, getString(R.string.invalid_email_password), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public LoginViewModel getViewModel() {
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

}
