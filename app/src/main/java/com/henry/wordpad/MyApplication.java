package com.henry.wordpad;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/1/18.
 */

public class MyApplication extends Application {
    public static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

    }

    public static Context getInstence() {
        return appContext;
    }


}
