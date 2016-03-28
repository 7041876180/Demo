package com.zhangyongyi.mydemo;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/1/16.
 */
public class BaseApplication extends Application{
    private static Context context;


    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }
    public static Context getContext() {
        return context;
    }
}
