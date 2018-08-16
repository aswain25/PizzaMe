package com.example.admin.pizzame.services;


import android.content.Context;

import com.example.admin.pizzame.R;
import com.example.admin.pizzame.models.YahooResponse;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

public class RetrofitHelper {

    Context context;

    public RetrofitHelper(Context applicationContext) {
        this.context = applicationContext;
    }

    public  Retrofit create(String BaseURL)  {

        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(loggingInterceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit;

    }

    public Call<YahooResponse> getResponse(String search, String format, String diagnostics, String callback){
        return create(context.getResources().getString(R.string.base_url))
                .create(RetrofitService.class)
                .getResponse(search, format, diagnostics, callback);
    }
}