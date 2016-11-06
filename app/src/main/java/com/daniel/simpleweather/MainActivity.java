package com.daniel.simpleweather;

import android.databinding.DataBindingUtil;
import android.support.v4.text.BidiFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.daniel.simpleweather.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        WeatherBean w = new WeatherBean();
        w.description =  "I am weather description.";
        binding.setVariable(com.daniel.simpleweather.BR.weather, w);

    }
}
