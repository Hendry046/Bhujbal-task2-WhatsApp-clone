package com.example.hendry_whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hendry_whatsapp.Model.DataModel.OrderDetail;
import com.example.hendry_whatsapp.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private Context context;
    private List<OrderDetail> list;

    public MainAdapter(Context context, List<OrderDetail> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_child_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.itemName.setText(list.get(position).getProduct_name());
        holder.quantity.setText(list.get(position).getProduct_qty()
                + " " + list.get(position).getUnit_name());

        if(list.get(position).getOrder_status().equals("Pending")){
            holder.setNotDelivered();
        }
        else {
            holder.setDelivered();
        }

        //image loading
        holder.setItemImage(list.get(position).getProduct_img_url());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

