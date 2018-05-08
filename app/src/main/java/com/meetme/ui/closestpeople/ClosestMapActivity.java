package com.meetme.ui.closestpeople;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.meetme.BR;
import com.meetme.R;
import com.meetme.databinding.ActivityClosestMapBinding;
import com.meetme.ui.base.BaseActivity;

import javax.inject.Inject;

public class ClosestMapActivity extends BaseActivity<ActivityClosestMapBinding, ClosestMapViewModel> implements ClosestNavigator {

    @Inject
    ClosestMapViewModel closestMapViewModel;

    ActivityClosestMapBinding mActivityClosestBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityClosestBinding = getViewDataBinding();
        closestMapViewModel.setNavigator(this);
    }

    @Override
    public ClosestMapViewModel getViewModel() {
        return closestMapViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_closest_map;
    }

    @Override
    public void showMeetingInfo() {

    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, ClosestMapActivity.class);
    }
}
