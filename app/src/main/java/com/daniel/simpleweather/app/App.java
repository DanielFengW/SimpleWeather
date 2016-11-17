package com.daniel.simpleweather.app;

import android.app.Application;
import android.content.Context;

import com.daniel.simpleweather.util.AppUtil;
import com.daniel.simpleweather.util.L;

/**
 * Created by Daniel Feng W on 2016/11/16.
 */

public class App extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        String sha1 = AppUtil.getSHA1(this);
        L.d("SHA1 = " + sha1);
    }

    public static Context getContext() {
        return mContext;
    }
}
