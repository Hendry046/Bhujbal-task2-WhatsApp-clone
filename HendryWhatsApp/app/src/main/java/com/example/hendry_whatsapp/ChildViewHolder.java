package com.example.hendry_whatsapp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hendry_whatsapp.R;

public class ChildViewHolder extends RecyclerView.ViewHolder {

    TextView userName;
    RecyclerView recyclerView;

    public ChildViewHolder(@NonNull View itemView) {
        super(itemView);

        userName=itemView.findViewById(R.id.userName);
        recyclerView=itemView.findViewById(R.id.childRecyclerView);
    }
}
