package com.meetme.ui.introduction.fragments;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.meetme.BR;
import com.meetme.R;
import com.meetme.databinding.FragmentIntroductionBinding;
import com.meetme.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * Created by user on 15.02.2018.
 */

public class IntroductionFragment extends BaseFragment<FragmentIntroductionBinding, IntroductionFragmentViewModel> {


    private int position = 0;
    private OnFragmentToActivity onFragmentToActivityListener;

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onFragmentToActivityListener = (OnFragmentToActivity) context;
    }

    private void setUp() {
        position = getArguments().getInt("position");

        switch (position) {
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

    public interface OnFragmentToActivity {
        void openNextFragment();
    }
}
