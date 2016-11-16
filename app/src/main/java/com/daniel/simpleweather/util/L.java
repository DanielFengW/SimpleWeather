package com.daniel.simpleweather.util;

import android.content.Context;
import android.util.Log;

import com.orhanobut.logger.BuildConfig;
import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;


/**
 * Created by Daniel Feng W on 2016/11/16.
 */

public class L {
    private static boolean debug = BuildConfig.DEBUG;
    public static boolean allowV = true;
    public static boolean allowD = true;
    public static boolean allowI = true;
    public static boolean allowW = true;
    public static boolean allowE = true;
    public static boolean allowWtf = true;
    private static boolean allowJson = true;
    private static boolean allowXml = true;

    public static void v(String content) {
        if (!allowV || !debug) return;
        Logger.v(content);
    }

    public static void d(String content) {
        if (!allowD || !debug) return;
        Logger.d(content);
    }

    public static void i(String content) {
        if (!allowI || !debug) return;
        Logger.i(content);
    }

    public static void e(String content) {
        if (!allowE || !debug) return;
        Logger.e(content);
    }

    public static void w(String content) {
        if (!allowW || !debug) return;
        Logger.w(content);
    }


    public static void wtf(String content) {
        if (!allowWtf || !debug) return;
        Logger.wtf(content);
    }

    public static void xml(String content) {
        if (!allowXml || !debug) return;
        Logger.xml(content);
    }

    public static void json(String content) {
        if (!allowJson || !debug) return;
        Logger.json(content);
    }

}
