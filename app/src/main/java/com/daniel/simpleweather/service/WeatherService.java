package com.daniel.simpleweather.service;

import com.daniel.simpleweather.WeatherBean;
import com.daniel.simpleweather.app.KeyStore;
import com.daniel.simpleweather.bean.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Daniel Feng W on 2016/11/6.
 */
public interface WeatherService {

//    http://api.map.baidu.com/telematics/v3/weather?location=广州&output=JSON&ak=FK9mkfdQsloEngodbFl4FeY3

    @GET("weather")
    Call<WeatherResponse> getWeatherResponse(@Query("location") String location);

}
