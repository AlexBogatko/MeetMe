package com.meetme.ui.introduction;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.databinding.PropertyChangeRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.util.Pair;

import com.meetme.BR;
import com.meetme.R;
import com.meetme.databinding.ActivityIntroductionBinding;
import com.meetme.ui.base.BaseActivity;
import com.meetme.ui.closestpeople.ClosestMapActivity;
import com.meetme.ui.introduction.fragments.IntroductionFragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by user on 13.02.2018.
 */

public class IntroductionActivity extends BaseActivity<ActivityIntroductionBinding, IntroductionViewModel> implements HasSupportFragmentInjector,
        IntroductionNavigator, IntroductionFragment.OnFragmentToActivity {

    private final static int LOCATION_PERMISSION = 101;
    private final static int STORAGE_PERMISSION = 102;
    private final static int CAMERA_PERMISSION = 103;

    @Inject
    IntroductionPagerAdapter mIntroductionPagerAdapter;

    @Inject
    IntroductionViewModel mIntroductionViewModel;

    ActivityIntroductionBinding mActivityIntroductionBinding;

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;
    private transient PropertyChangeRegistry propertyChangeRegistry = new PropertyChangeRegistry();

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

    private void setUp() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        mActivityIntroductionBinding = DataBindingUtil.setContentView(this, R.layout.activity_introduction);
        mActivityIntroductionBinding.setVariable(getBindingVariable(), mIntroductionViewModel);
        mActivityIntroductionBinding.executePendingBindings();

        mIntroductionPagerAdapter.setCount(3);
        mActivityIntroductionBinding.introductionViewPager.setAdapter(mIntroductionPagerAdapter);

        mActivityIntroductionBinding.introductionViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (position == 2) {
                    mActivityIntroductionBinding.rightBottomButton.setText("ready");
                } else {
                    mActivityIntroductionBinding.rightBottomButton.setText("next");
                }
            }
        });
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

    @Override
    public void openNextActivity() {
        startActivity(ClosestMapActivity.getStartIntent(this));
    }

    @Override
    public void setIsLoading() {

    }

    @Override
    public void setNotLoading() {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if ((requestCode == LOCATION_PERMISSION
                || requestCode == STORAGE_PERMISSION
                || requestCode == CAMERA_PERMISSION) && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            openNextFragment();
        }
    }

    private String[] arrayOf(String... values) {
        return values;
    }

    @Override
    public void requestPermission(){
        Pair<String[], Integer> permissionRequestCode = getRequestPermission();

        String[] permissions = permissionRequestCode.first;
        int requestCode = permissionRequestCode.second;

        if (ContextCompat.checkSelfPermission(this, permissions[0])
                != PackageManager.PERMISSION_GRANTED) {

            // No explanation needed, we can request the permission.
            ActivityCompat.requestPermissions(this,
                    arrayOf(permissions),
                    requestCode);
        } else {
            openNextFragment();
        }
    }

    private Pair<String[], Integer> getRequestPermission(){
        switch (mActivityIntroductionBinding.introductionViewPager.getCurrentItem()){
            case 0:
                return new Pair<>(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_PERMISSION);
            case 1:
                return new Pair<>(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE}, STORAGE_PERMISSION);
            case 2:
                return new Pair<>(new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSION);
            default:
                return null;
        }
    }

    @Override
    public void openNextFragment() {
        int currItem = mActivityIntroductionBinding.introductionViewPager.getCurrentItem();

        if (currItem < 2) {
            mActivityIntroductionBinding.introductionViewPager.setCurrentItem(currItem + 1);
        } else {
            openNextActivity();
        }
    }
}
