package com.daniel.simpleweather.app;

import android.app.Application;
import android.content.Context;

import com.daniel.simpleweather.BuildConfig;
import com.daniel.simpleweather.util.AppUtil;
import com.daniel.simpleweather.util.L;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;

/**
 * Created by Daniel Feng W on 2016/11/16.
 */
public class App extends Application {

    public static final String DEFAULT_TAG = "SimpleWeather";
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        printSHA1();
        initLogger();
    }

    private void printSHA1() {
        String sha1 = AppUtil.getSHA1(this);
        L.d("SHA1 = " + sha1);
    }

    private void initLogger() {
        Logger
                .init(DEFAULT_TAG)
                .methodCount(3)
                .hideThreadInfo()
                .logLevel(BuildConfig.DEBUG ? LogLevel.FULL : LogLevel.NONE)
                .methodOffset(2);
    }

    public static Context getContext() {
        return mContext;
    }
}
