package com.fhzn.db1.ui.tab_bar.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.fhzn.db1.BR;
import com.fhzn.db1.R;

import com.fhzn.common.base.BaseFragment;

/**
 * Created by zhaozq on 2018/7/18.
 */

public class TabBar4Fragment extends BaseFragment {
    @Override
    public int initContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return R.layout.fragment_tab_bar_4;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
