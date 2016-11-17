package com.daniel.simpleweather.service;

import com.daniel.simpleweather.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by Daniel Feng W on 2016/11/17.
 */

public class MyRetrofit {

    private static volatile MyRetrofit instance;

    private final WeatherService weatherService;

    private MyRetrofit() {
        OkHttpClient baiduClient = new OkHttpClient.Builder().addInterceptor(new BaiduIntercepter()).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.WEATHER_BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(baiduClient)
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    public static MyRetrofit getInstance() {
        if (instance == null) {
            synchronized (MyRetrofit.class) {
                if (instance == null) {
                    instance = new MyRetrofit();
                }
            }
        }
        return instance;
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }
}
