package com.fhzn.db1.ui.network.detail;

import android.app.Application;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;

import com.fhzn.db1.entity.DemoEntity;

import com.fhzn.common.base.BaseViewModel;

/**
 * Created by zhaozq on 2020/5/15.
 */

public class DetailViewModel extends BaseViewModel {
    public ObservableField<DemoEntity.ItemsEntity> entity = new ObservableField<>();

    public DetailViewModel(@NonNull Application application) {
        super(application);
    }

    public void setDemoEntity(DemoEntity.ItemsEntity entity) {
        this.entity.set(entity);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        entity = null;
    }
}
