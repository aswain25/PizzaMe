package com.example.admin.pizzame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.pizzame.models.YahooResponse;
import com.example.admin.pizzame.services.RetrofitHelper;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test
        RetrofitHelper retrofitHelper = new RetrofitHelper(this);
        retrofitHelper.getResponse("select * from local.search where zip = 30132 and query = pizza", "json", "true", "")
                .enqueue(new Callback<YahooResponse>() {
                    @Override
                    public void onResponse(Call<YahooResponse> call, Response<YahooResponse> response)
                    {
                        int i = 0;
                    }

                    @Override
                    public void onFailure(Call<YahooResponse> call, Throwable t)
                    {
                    }
                });
    }
}
