package com.zxf;

import android.app.Application;

import com.taobao.sophix.SophixManager;

/**
 * Created by zxf on 2019/3/30.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SophixManager.getInstance().queryAndLoadNewPatch();
    }
}
