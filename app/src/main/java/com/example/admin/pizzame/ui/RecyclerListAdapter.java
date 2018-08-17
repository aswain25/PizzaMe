package com.example.admin.pizzame.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.pizzame.R;
import com.example.admin.pizzame.models.ResultItem;
import com.example.admin.pizzame.models.YahooResponse;

public class RecyclerListAdapter extends RecyclerView.Adapter<RecyclerListAdapter.ViewHolder> {
    YahooResponse results;
    Context context;
    Handler activityHandler;

    public RecyclerListAdapter(YahooResponse results, Context context, Handler activityHandler) {
        this.results = results;
        this.context = context;
        this.activityHandler = activityHandler;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.simple_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final ResultItem item = results.getQuery().getResults().getResult().get(position);

        if (item != null) {
            holder.tvTitle.setText(item.getTitle());//Name, Address, City, State, distance(in miles), phone number
            holder.tvAddress.setText(item.getAddress());
            holder.tvCity.setText(item.getCity());
            holder.tvState.setText(item.getState());
            holder.tvDistance.setText(item.getDistance());

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Message message = new Message();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("item", item);
                    message.setData(bundle);
                    activityHandler.sendMessage(message);
                }
            });
        }
    }



    @Override
    public int getItemCount() {
        return results.getQuery().getResults().getResult().size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        private final TextView tvTitle;
        private final TextView tvAddress;
        private final TextView tvCity;
        private final TextView tvState;
        private final TextView tvDistance;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvState = itemView.findViewById(R.id.tvState);
            tvDistance = itemView.findViewById(R.id.tvDistance);
        }
    }
}