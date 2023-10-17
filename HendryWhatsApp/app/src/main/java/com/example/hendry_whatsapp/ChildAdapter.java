package com.example.hendry_whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hendry_whatsapp.Model.DataModel.UserData;
import com.example.hendry_whatsapp.R;

import java.util.List;

public class ChildAdapter extends RecyclerView.Adapter<ChildViewHolder> {

    private Context context;
    private List<UserData> list;

    public ChildAdapter(Context context, List<UserData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChildViewHolder(LayoutInflater.from(context).inflate(R.layout.child_data_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder holder, int position) {
        holder.userName.setText(list.get(position).getName());
        MainAdapter mainAdapter = new MainAdapter(context, list.get(position).getOrder_detail());
        holder.recyclerView.setAdapter(mainAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context.getApplicationContext()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
