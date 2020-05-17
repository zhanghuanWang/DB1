package com.fhzn.common.binding.viewadapter.viewgroup;

/**
 * Created by zhaozq on 2017/6/15.
 */

import android.databinding.ViewDataBinding;

public interface IBindingItemViewModel<V extends ViewDataBinding> {
    void injecDataBinding(V binding);
}
