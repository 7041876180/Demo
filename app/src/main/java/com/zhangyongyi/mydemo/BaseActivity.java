package com.zhangyongyi.mydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by dllo on 16/3/28.
 */
public abstract class BaseActivity extends AppCompatActivity{
    protected static final String TAG = BaseActivity.class.getSimpleName();
    protected String tag = this.getClass().getSimpleName();
    protected Toolbar mToolbar;


    protected <T extends View> T findView(int resId){
        T t = (T) findViewById(resId);
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initPresenter();
        initView();
        initData();
    }

    /**
     * 初始化Presenter
     */
    protected void initPresenter() {

    }

    //获取要加载的布局
    protected abstract int getLayout();

    //初始化组件
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();


    //activity页面跳转动画函数
    protected void overridePendingAnimation() {
    }


    //页面的跳转并保存数据
    protected abstract void intentActivityData();

    //activity跳转

    protected void activityIntent() {
        intentActivityData();
        overridePendingAnimation();
    }
}
