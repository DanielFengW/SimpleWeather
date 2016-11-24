package com.daniel.simpleweather.net;

import com.daniel.simpleweather.app.KeyStore;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Daniel Feng W on 2016/11/17.
 */
public class BaiduIntercepter implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        HttpUrl httpUrl = request.url().newBuilder()
                .addQueryParameter("ak", KeyStore.BAIDU_AK)
                .addQueryParameter("output", "json")
                .addQueryParameter("mcode", KeyStore.BAIDU_MCODE)
                .build();
        request = request.newBuilder().url(httpUrl).build();
        return chain.proceed(request);
    }
}
