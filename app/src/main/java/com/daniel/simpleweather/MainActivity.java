package com.daniel.simpleweather;

import android.databinding.DataBindingUtil;
import android.support.v4.text.BidiFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.daniel.simpleweather.bean.WeatherResponse;
import com.daniel.simpleweather.databinding.ActivityMainBinding;
import com.daniel.simpleweather.service.MyRetrofit;
import com.daniel.simpleweather.service.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        WeatherBean w = new WeatherBean();
        w.description = "I am weather description.";
        binding.setVariable(com.daniel.simpleweather.BR.weather, w);

        WeatherService weatherService = MyRetrofit.getInstance().getWeatherService();
        Call<WeatherResponse> weatherResponseCall = weatherService.getWeatherResponse("北京");

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                WeatherResponse body = response.body();
                Log.d(TAG, "onResponse: " + body.toString());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
    }
}
