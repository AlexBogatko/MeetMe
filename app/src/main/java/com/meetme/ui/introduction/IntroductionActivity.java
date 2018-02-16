package com.meetme.ui.introduction;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.meetme.BR;
import com.meetme.R;
import com.meetme.databinding.ActivityIntroductionBinding;
import com.meetme.ui.base.BaseActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by user on 13.02.2018.
 */

public class IntroductionActivity extends BaseActivity<ActivityIntroductionBinding, IntroductionViewModel> implements HasSupportFragmentInjector,
        IntroductionNavigator{

    @Inject
    IntroductionPagerAdapter mIntroductionPagerAdapter;

    @Inject
    IntroductionViewModel mIntroductionViewModel;

    ActivityIntroductionBinding mActivityIntroductionBinding;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, IntroductionActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityIntroductionBinding = getViewDataBinding();
        mIntroductionViewModel.setNavigator(this);
        setUp();
    }

    private void setUp(){
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        mActivityIntroductionBinding = DataBindingUtil.setContentView(this, R.layout.activity_introduction);
        mActivityIntroductionBinding.setVariable(getBindingVariable(), mIntroductionViewModel);
        mActivityIntroductionBinding.executePendingBindings();

        mIntroductionPagerAdapter.setCount(3);
        mActivityIntroductionBinding.introductionViewPager.setAdapter(mIntroductionPagerAdapter);;
    }

    @Override
    public void openNextActivity() {

    }

    @Override
    public IntroductionViewModel getViewModel() {
        return mIntroductionViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_introduction;
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }
}
