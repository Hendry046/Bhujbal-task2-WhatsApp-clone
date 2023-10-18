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

        holder.selectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (holder.clickedCount == 0) {
                    selectAll(holder);
                    holder.clickedOnce();
                } else {
                    removeAll(holder);
                    holder.clickedCount = 0;  // Reset the clicked count
                }
            }
        });
    }

    private void removeAll(ParentViewHolder holder) {
        for (int i = 0; i < holder.recyclerView.getAdapter().getItemCount(); i++) {
            RecyclerView.ViewHolder viewHolder = holder.recyclerView.findViewHolderForAdapterPosition(i);

            if (viewHolder instanceof ChildViewHolder) {
                RecyclerView recyclerView2 = viewHolder.itemView.findViewById(R.id.childRecyclerView);

                // Iterate through every item
                for (int j = 0; j < recyclerView2.getAdapter().getItemCount(); j++) {
                    RecyclerView.ViewHolder viewHolder2 = recyclerView2.findViewHolderForAdapterPosition(j);

                    if (viewHolder2 instanceof MainViewHolder) {
                        ((MainViewHolder) viewHolder2).setNotDelivered();
                    }
                }
            }
        }
        holder.selectBtn.setText("Select All");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    private void selectAll(ParentViewHolder holder){
        for (int i=0; i<holder.recyclerView.getAdapter().getItemCount(); i++){
            RecyclerView.ViewHolder viewHolder = holder.recyclerView.findViewHolderForAdapterPosition(i);

            if(viewHolder instanceof ChildViewHolder){
                RecyclerView recyclerView2 = viewHolder.itemView.findViewById(R.id.childRecyclerView);

                //Iterate through every item
                for(int j=0; j<recyclerView2.getAdapter().getItemCount(); j++){
                    RecyclerView.ViewHolder viewHolder2 = recyclerView2.findViewHolderForAdapterPosition(j);

                    if (viewHolder2 instanceof MainViewHolder){
                        ((MainViewHolder) viewHolder2).setDelivered();
                    }
                }
            }
        }

    }
}
