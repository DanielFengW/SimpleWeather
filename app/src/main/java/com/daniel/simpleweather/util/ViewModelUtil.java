package com.daniel.simpleweather.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.daniel.simpleweather.app.App;

/**
 * Created by Daniel on 2016/11/24.
 */
public class ViewModelUtil {

    @BindingAdapter({"bind:imageUrl"})
    public static void imageLoader(ImageView imageView, String url) {
        Glide.with(App.getContext()).load(url).into(imageView);
    }
}
