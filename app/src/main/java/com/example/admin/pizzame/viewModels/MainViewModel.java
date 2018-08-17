package com.example.admin.pizzame.viewModels;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.pizzame.models.YahooResponse;
import com.example.admin.pizzame.services.RetrofitHelper;
import com.example.admin.pizzame.ui.RecyclerListAdapter;
import com.example.admin.pizzame.util.LocationManager;
import com.example.admin.pizzame.util.PermissionManager;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel  implements PermissionManager.IPermissionManager
{
    RecyclerView rvMain;
    PermissionManager permissionManager;
    LocationManager locationManager;


    private Handler activityHandler;
    Context context;

    public MainViewModel(Context context, RecyclerView rv, Handler activityHandler)
    {
        this.context = context;
        this.activityHandler = activityHandler;

        this.rvMain = rv;

        permissionManager = new PermissionManager(context, this);
        locationManager = new LocationManager(context);

        try {
            permissionManager.checkPermission();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        try {
            permissionManager.checkResult(requestCode, permissions, grantResults);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onPermissionResult(boolean isGranted) throws IOException {
        if (isGranted)
        {
            locationManager.getLocation(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    RetrofitHelper retrofitHelper = new RetrofitHelper(context.getApplicationContext());
                    try {
                        retrofitHelper.getResponse("select * from local.search where zip = " + getZipCodeFromLocation(location) + " and query = 'pizza'", "json", "true", ">")
                                .enqueue(new Callback<YahooResponse>() {
                                    @Override
                                    public void onResponse(Call<YahooResponse> call, Response<YahooResponse> response)
                                    {
                                        RecyclerListAdapter adapter = new RecyclerListAdapter(response.body(), context.getApplicationContext(), activityHandler);
                                        rvMain.setAdapter(adapter);
                                        rvMain.setLayoutManager(new GridLayoutManager(context.getApplicationContext(), 2));
                                    }

                                    @Override
                                    public void onFailure(Call<YahooResponse> call, Throwable t)
                                    {
                                    }
                                });
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }
    }

    public void onStart() {
        locationManager.startLocationUpdates();
    }

    public void onStop() {
        locationManager.soptLocationUpdates();
    }

    private String getZipCodeFromLocation(Location location) throws IOException {
        Geocoder geocoder = new Geocoder(context);
        return geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1).get(0).getPostalCode();
    }
}
