package com.example.finalproject;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Post> dataList;

    public void setData(List<Post> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (dataList != null && position < dataList.size()) {
            Post currentItem = dataList.get(position);
            holder.titleTextView.setText(currentItem.gettitle());
            holder.textTextView.setText(currentItem.gettext());
            holder.publishedDateTextView.setText(currentItem.getdate());
            holder.createdDateTextView.setText(currentItem.getcdate());

            // Load image using Glide
            Glide.with(holder.itemView.getContext())
                    .load(currentItem.getimg())

                    .into(holder.imageView);

        }
    }

    @Override
    public int getItemCount() {
        return dataList != null ? dataList.size() : 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView textTextView;
        TextView publishedDateTextView;
        TextView createdDateTextView;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            textTextView = itemView.findViewById(R.id.textTextView);
            publishedDateTextView = itemView.findViewById(R.id.publishedDateTextView);
            createdDateTextView = itemView.findViewById(R.id.createdDateTextView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}