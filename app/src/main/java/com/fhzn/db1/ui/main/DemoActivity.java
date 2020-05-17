package com.fhzn.db1.ui.main;

import android.Manifest;
import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.fhzn.db1.BR;
import com.fhzn.db1.R;
import com.fhzn.db1.databinding.ActivityDemoBinding;
import com.tbruyelle.rxpermissions2.RxPermissions;

import io.reactivex.functions.Consumer;
import com.fhzn.common.base.BaseActivity;
import com.fhzn.common.http.DownLoadManager;
import com.fhzn.common.http.download.ProgressCallBack;
import com.fhzn.common.utils.ToastUtils;
import okhttp3.ResponseBody;

/**
 * Created by zhaozq on 2020/5/15.
 */

public class DemoActivity extends BaseActivity<ActivityDemoBinding, DemoViewModel> {
    @Override
    public void initParam() {
        super.initParam();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public int initContentView(Bundle savedInstanceState) {
        return R.layout.activity_demo;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public void initViewObservable() {
        //注册监听相机权限的请求
        viewModel.requestCameraPermissions.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                requestCameraPermissions();
            }
        });
        //注册文件下载的监听
        viewModel.loadUrlEvent.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String url) {
                downFile(url);
            }
        });
    }

    /**
     * 请求相机权限
     */
    private void requestCameraPermissions() {
        //请求打开相机权限
        RxPermissions rxPermissions = new RxPermissions(DemoActivity.this);
        rxPermissions.request(Manifest.permission.CAMERA)
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            ToastUtils.showShort("相机权限已经打开，直接跳入相机");
                        } else {
                            ToastUtils.showShort("权限被拒绝");
                        }
                    }
                });
    }

    private void downFile(String url) {
        String destFileDir = getApplication().getCacheDir().getPath();
        String destFileName = System.currentTimeMillis() + ".apk";
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("正在下载...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        DownLoadManager.getInstance().load(url, new ProgressCallBack<ResponseBody>(destFileDir, destFileName) {
            @Override
            public void onStart() {
                super.onStart();
            }

            @Override
            public void onCompleted() {
                progressDialog.dismiss();
            }

            @Override
            public void onSuccess(ResponseBody responseBody) {
                ToastUtils.showShort("文件下载完成！");
            }

            @Override
            public void progress(final long progress, final long total) {
                progressDialog.setMax((int) total);
                progressDialog.setProgress((int) progress);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                ToastUtils.showShort("文件下载失败！");
                progressDialog.dismiss();
            }
        });
    }
}
