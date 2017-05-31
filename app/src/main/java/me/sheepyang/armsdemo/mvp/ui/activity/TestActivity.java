package me.sheepyang.armsdemo.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import me.sheepyang.armsdemo.di.component.DaggerTestComponent;
import me.sheepyang.armsdemo.di.module.TestModule;
import me.sheepyang.armsdemo.mvp.contract.TestContract;
import me.sheepyang.armsdemo.mvp.presenter.TestPresenter;

import me.sheepyang.armsdemo.R;


import static com.jess.arms.utils.Preconditions.checkNotNull;


public class TestActivity extends BaseActivity<TestPresenter> implements TestContract.View {


    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerTestComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .testModule(new TestModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        return R.layout.activity_test; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }


}