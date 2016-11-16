package com.daniel.simpleweather.app;

import android.app.Application;

import com.daniel.simpleweather.util.AppUtil;
import com.daniel.simpleweather.util.L;

import static android.content.ContentValues.TAG;

/**
 * Created by Daniel Feng W on 2016/11/16.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        String sha1 = AppUtil.getCertificateSHA1Fingerprint(this);
        L.d("SHA1 = " + sha1);
    }
}
