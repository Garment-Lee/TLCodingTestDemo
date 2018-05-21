package com.lgf.tlcodingtestdemo.base;

import android.app.Application;

import com.lgf.tlcodingtestdemo.utils.LogUtil;

/**
 * Created by garment on 2018/5/20.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LogUtil.setLogcatEnable(true);
    }
}
