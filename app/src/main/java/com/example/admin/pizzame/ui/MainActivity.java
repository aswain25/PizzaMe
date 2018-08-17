package com.example.admin.pizzame.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.admin.pizzame.R;
import com.example.admin.pizzame.models.ResultItem;
import com.example.admin.pizzame.ui.ItemViewActivity;
import com.example.admin.pizzame.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private final Handler activityHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Intent intent = new Intent(getApplicationContext(), ItemViewActivity.class);
            ResultItem item = (ResultItem)msg.getData().getSerializable("item");
            intent.putExtra("item", item);
            startActivity(intent);
        }
    };

    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new MainViewModel(getApplicationContext(), (RecyclerView)findViewById(R.id.rvMain), activityHandler);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        viewModel.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onStart() {
        super.onStart();
        viewModel.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        viewModel.onStop();
    }
}
