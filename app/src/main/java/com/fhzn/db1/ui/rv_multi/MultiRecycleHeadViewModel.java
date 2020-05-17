package com.fhzn.db1.ui.rv_multi;

import android.support.annotation.NonNull;

import com.fhzn.common.base.BaseViewModel;
import com.fhzn.common.base.MultiItemViewModel;
import com.fhzn.common.binding.command.BindingAction;
import com.fhzn.common.binding.command.BindingCommand;
import com.fhzn.common.utils.ToastUtils;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：
 */

public class MultiRecycleHeadViewModel extends MultiItemViewModel {

    public MultiRecycleHeadViewModel(@NonNull BaseViewModel viewModel) {
        super(viewModel);
    }

    //条目的点击事件
    public BindingCommand itemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            ToastUtils.showShort("我是头布局");
        }
    });
}
