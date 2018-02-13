package com.meetme.ui.introduction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.meetme.databinding.ActivityIntroductionBinding;
import com.meetme.ui.base.BaseActivity;

import javax.inject.Inject;

/**
 * Created by user on 13.02.2018.
 */

public class IntroductionActivity extends BaseActivity<ActivityIntroductionBinding, IntroductionViewModel> {

    @Inject
    IntroductionViewModel mIntroductionViewModel;

    ActivityIntroductionBinding mActivityIntroductionBinding;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, IntroductionActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityIntroductionBinding = getViewDataBinding();

    }

    @Override
    public IntroductionViewModel getViewModel() {
        return mIntroductionViewModel;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return 0;
    }
}
