package com.fhzn.db1.data.source;

import com.fhzn.db1.entity.DemoEntity;

import io.reactivex.Observable;
import com.fhzn.common.http.BaseResponse;

/**
 * Created by zhaozq on 2019/3/26.
 */
public interface HttpDataSource {
    //模拟登录
    Observable<Object> login();

    //模拟上拉加载
    Observable<DemoEntity> loadMore();

    Observable<BaseResponse<DemoEntity>> demoGet();

    Observable<BaseResponse<DemoEntity>> demoPost(String catalog);


}
