package com.example.hendry_whatsapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hendry_whatsapp.R;

public class ParentViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;
    TextView groupName;
    ImageView arrowStatus;
    LinearLayout groupCard;
    boolean status = false;

    public ParentViewHolder(@NonNull View itemView) {
        super(itemView);

        groupName=itemView.findViewById(R.id.groupName);
        arrowStatus=itemView.findViewById(R.id.groupStatusArrow);
        groupCard=itemView.findViewById(R.id.groupCard);
        recyclerView=itemView.findViewById(R.id.parentRecyclerView);
    }

    public void groupClicked(){
        if(status){
            collapseGroup();
        }
        else{
            expandGroup();
        }
    }

    public void expandGroup(){
        recyclerView.setVisibility(View.VISIBLE);
        arrowStatus.setImageResource(R.drawable.arrow_up);

        status=true;
    }

    public void collapseGroup(){
        recyclerView.setVisibility(View.GONE);
        arrowStatus.setImageResource(R.drawable.arrow_down);

        status=false;
    }
}
