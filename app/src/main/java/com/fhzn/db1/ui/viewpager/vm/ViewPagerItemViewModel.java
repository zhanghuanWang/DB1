package com.fhzn.db1.ui.viewpager.vm;

import android.support.annotation.NonNull;

import com.fhzn.common.base.ItemViewModel;
import com.fhzn.common.binding.command.BindingAction;
import com.fhzn.common.binding.command.BindingCommand;

/**
 * 所有例子仅做参考,千万不要把它当成一种标准,毕竟主打的不是例子,业务场景繁多,理解如何使用才最重要。
 * Created by zhaozq on 2018/7/18.
 */

public class ViewPagerItemViewModel extends ItemViewModel<ViewPagerViewModel> {
    public String text;

    public ViewPagerItemViewModel(@NonNull ViewPagerViewModel viewModel, String text) {
        super(viewModel);
        this.text = text;
    }

    public BindingCommand onItemClick = new BindingCommand(new BindingAction() {
        @Override
        public void call() {
            //点击之后将逻辑转到activity中处理
            viewModel.itemClickEvent.setValue(text);
        }
    });
}
