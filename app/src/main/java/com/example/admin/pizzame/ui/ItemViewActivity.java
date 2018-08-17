package com.example.admin.pizzame.ui;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.pizzame.R;
import com.example.admin.pizzame.models.ResultItem;
import com.example.admin.pizzame.viewModels.ItemViewActivityVewModel;

public class ItemViewActivity extends AppCompatActivity {

    ResultItem item;

    private TextView tvTitle;
    private TextView tvAddress;
    private TextView tvCity;
    private TextView tvState;
    private TextView tvDistance;

    ItemViewActivityVewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        tvTitle = findViewById(R.id.tvTitle);
        tvAddress = findViewById(R.id.tvAddress);
        tvCity = findViewById(R.id.tvCity);
        tvState = findViewById(R.id.tvState);
        tvDistance = findViewById(R.id.tvDistance);

        item = (ResultItem) getIntent().getSerializableExtra("item");

        tvTitle.setText(item.getTitle());//Name, Address, City, State, distance(in miles), phone number
        tvAddress.setText(item.getAddress());
        tvCity.setText(item.getCity());
        tvState.setText(item.getState());
        tvDistance.setText(item.getDistance());

        viewModel = new ItemViewActivityVewModel();
    }

    public void btnCall_Clicked(View view) {
        viewModel.MakeCall(this, item);
    }

    public void btnDirections_Clicked(View view)
    {
        viewModel.GetDirections(this, item);
    }
}
