package com.innershows.findwhatyoulike;

import android.app.Application;

/**
 * Created by innershows on 16/8/10.
 *
 * @author innershows
 * @date 16/8/10
 * @e_mail innershow@gmail.com
 */
public class MyApp extends Application {

    private static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    /**
     * 这个方法用来提供给外部使用
     *
     * @return 返回一个Application对象
     */
    public static MyApp getApp() {
        return app;
    }
}
