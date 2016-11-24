package com.daniel.simpleweather;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daniel.simpleweather.bean.WeatherResponse;
import com.daniel.simpleweather.databinding.ActivityMainBinding;
import com.daniel.simpleweather.net.MyRetrofit;
import com.daniel.simpleweather.net.WeatherService;
import com.daniel.simpleweather.util.L;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private final String TAG = getClass().getSimpleName();
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        WeatherBean w = new WeatherBean();
        w.description = "I am weather description.";

        mBinding.setVariable(com.daniel.simpleweather.BR.weather, w);
        mBinding.setWeather(w);


        WeatherService weatherService = MyRetrofit.getInstance().getWeatherService();
        Call<WeatherResponse> weatherResponseCall = weatherService.getWeatherResponse("北京");

        weatherResponseCall.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                WeatherResponse body = response.body();
                String dayPictureUrl = body.getResults().get(0).getWeather_data().get(0).getDayPictureUrl();
                mBinding.setImgUrl(dayPictureUrl);
                L.d(body.toString());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
    }
}
