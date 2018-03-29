package com.meetme.ui.introduction;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.meetme.BR;
import com.meetme.R;
import com.meetme.ViewModelProviderFactory;
import com.meetme.databinding.FragmentIntroductionBinding;
import com.meetme.ui.base.BaseFragment;
import com.meetme.ui.base.BaseViewModel;

import javax.inject.Inject;

/**
 * Created by user on 15.02.2018.
 */

public class IntroductionFragment extends BaseFragment<FragmentIntroductionBinding, IntroductionFragmentViewModel> {

    @Inject
    ViewModelProvider.Factory mViewModelFactory;

    FragmentIntroductionBinding mFragmentIntroductionBinding;
    IntroductionFragmentViewModel mIntroductionViewModel;

    public static IntroductionFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);

        IntroductionFragment fragment = new IntroductionFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mFragmentIntroductionBinding = getViewDataBinding();
        setUp();
    }

    private void setUp() {
        switch (getArguments().getInt("position")) {
            case 0:
                mFragmentIntroductionBinding.button.setText("first page");
                break;
            case 1:
                mFragmentIntroductionBinding.button.setText("second page");
                break;
            case 2:
                mFragmentIntroductionBinding.button.setText("third page");
                break;
        }
    }

    @Override
    public IntroductionFragmentViewModel getViewModel() {
        mIntroductionViewModel = ViewModelProviders.of(this, mViewModelFactory).get(IntroductionFragmentViewModel.class);
        return mIntroductionViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_introduction;
    }
}
