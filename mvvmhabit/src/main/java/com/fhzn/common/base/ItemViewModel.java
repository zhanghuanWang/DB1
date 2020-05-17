package com.fhzn.common.base;

import android.support.annotation.NonNull;

/**
 * ItemViewModel
 * Created by zhaozq on 2018/10/3.
 */

public class ItemViewModel<VM extends BaseViewModel> {
    protected VM viewModel;

    public ItemViewModel(@NonNull VM viewModel) {
        this.viewModel = viewModel;
    }
}
