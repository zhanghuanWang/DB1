package com.fhzn.db1.ui.viewpager.adapter;

import android.databinding.ViewDataBinding;
import android.view.ViewGroup;

import com.fhzn.db1.databinding.ItemViewpagerBinding;
import com.fhzn.db1.ui.viewpager.vm.ViewPagerItemViewModel;

import me.tatarka.bindingcollectionadapter2.BindingViewPagerAdapter;

/**
 * Created by zhaozq on 2018/6/21.
 */

public class ViewPagerBindingAdapter extends BindingViewPagerAdapter<ViewPagerItemViewModel> {

    @Override
    public void onBindBinding(final ViewDataBinding binding, int variableId, int layoutRes, final int position, ViewPagerItemViewModel item) {
        super.onBindBinding(binding, variableId, layoutRes, position, item);
        //这里可以强转成ViewPagerItemViewModel对应的ViewDataBinding，
        ItemViewpagerBinding _binding = (ItemViewpagerBinding) binding;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
}
