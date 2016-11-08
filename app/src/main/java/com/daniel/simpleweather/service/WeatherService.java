package com.daniel.simpleweather.service;

import com.daniel.simpleweather.WeatherBean;
import com.daniel.simpleweather.bean.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Daniel Feng W on 2016/11/6.
 */

public interface WeatherService {

    @GET("/data/sk/{id}.html")
    Call<WeatherResponse> getWeatherResponse(@Path("id") String id);  //test id = 101010100



}
