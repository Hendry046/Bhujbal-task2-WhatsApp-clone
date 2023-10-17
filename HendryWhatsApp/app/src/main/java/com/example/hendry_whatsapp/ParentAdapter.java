package com.example.hendry_whatsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hendry_whatsapp.Model.DataModel.GroupData;
import com.example.hendry_whatsapp.R;

import java.util.List;

public class ParentAdapter extends RecyclerView.Adapter<ParentViewHolder> {

    private Context context;
    private List<GroupData> arrayList;

    public ParentAdapter(Context context, List<GroupData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }


    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ParentViewHolder(LayoutInflater.from(context).inflate(R.layout.parent_data_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder holder, int position) {
        holder.groupName.setText(arrayList.get(position).getGroup_name());

        ChildAdapter childAdapter = new ChildAdapter(context, arrayList.get(position).getGroup_data());
        holder.recyclerView.setAdapter(childAdapter);
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context));

        holder.groupCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.groupClicked();
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}

