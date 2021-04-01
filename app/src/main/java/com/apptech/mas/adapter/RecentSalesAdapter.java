package com.apptech.mas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.apptech.mas.databinding.RowRecentSalesBinding;
import com.apptech.mas.model.recent_sales.RecentSalesList;
import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RecentSalesAdapter extends RecyclerView.Adapter<RecentSalesAdapter.ViewBinding> {

    Context context;
    RowRecentSalesBinding binding;
    List<RecentSalesList> recentSalesLists;

    public RecentSalesAdapter(Context context , List<RecentSalesList> recentSalesLists) {
        this.context = context;
        this.recentSalesLists = recentSalesLists;
    }

    @NonNull
    @NotNull
    @Override
    public ViewBinding onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = RowRecentSalesBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewBinding(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewBinding holder, int position) {
        RecentSalesList list = recentSalesLists.get(position);
        Glide.with(context).load(list.getImg()).centerCrop().into(binding.image);
        binding.recentSalestitle.setText(list.getName());
        binding.recentSalesPrice.setText("Price " + list.getAmt());
        binding.recentSalesQty.setText("No. of item : " + list.getQty());
    }

    @Override
    public int getItemCount() {
        return recentSalesLists.size();
    }

    public static class ViewBinding extends RecyclerView.ViewHolder {
        public ViewBinding(@NonNull @NotNull RowRecentSalesBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
