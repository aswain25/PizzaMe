package com.example.admin.pizzame.viewModels;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.example.admin.pizzame.models.ResultItem;

public class ItemViewActivityVewModel
{

    public void MakeCall(Context context, ResultItem item) {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + item.getPhone()));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(context, "Please enable calling permissions", Toast.LENGTH_SHORT);
            return;
        }
        context.startActivity(callIntent);
    }

    public void GetDirections(Context context, ResultItem item)
    {
        // Creates an Intent that will load a map of San Francisco
        Uri gmmIntentUri = Uri.parse("geo:" + item.getLatitude() + "," + item.getLongitude());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
    }
}
