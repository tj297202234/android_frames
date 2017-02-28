package com.tongjin.frames;

import android.app.Application;

import com.itheima.retrofitutils.ItheimaHttp;

/**
 * Created by tj on 2017/2/27.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 初始化 RetrofitUtils
        ItheimaHttp.init(this, AppCfg.BASE_URL);
        ItheimaHttp.setHttpCache(false);//false不缓存，true缓存
    }
}
