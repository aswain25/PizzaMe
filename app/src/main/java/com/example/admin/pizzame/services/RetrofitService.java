package com.example.admin.pizzame.services;

import com.example.admin.pizzame.models.YahooResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RetrofitService {
    @GET("yql")
    Call<YahooResponse> getResponse(
            @Query("q") String search,
            @Query("format") String format,
            @Query("diagnostics") String diagnostics,
            @Query("callback") String callback);
}