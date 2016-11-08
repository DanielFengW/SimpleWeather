package com.daniel.simpleweather;

import android.databinding.DataBindingUtil;
import android.support.v4.text.BidiFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.daniel.simpleweather.bean.WeatherResponse;
import com.daniel.simpleweather.databinding.ActivityMainBinding;
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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.weather.com.cn")
                //增加返回值为String的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //增加返回值为Gson的支持(以实体类返回)
                .addConverterFactory(GsonConverterFactory.create())
                //增加返回值为Oservable<T>的支持
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        WeatherService weatherService = retrofit.create(WeatherService.class);
        Call<WeatherResponse> weatherResponseCall = weatherService.getWeatherResponse("101010100");
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
