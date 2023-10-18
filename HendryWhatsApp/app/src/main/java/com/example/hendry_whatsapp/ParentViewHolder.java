package com.example.hendry_whatsapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hendry_whatsapp.R;
import com.google.android.material.button.MaterialButton;

public class ParentViewHolder extends RecyclerView.ViewHolder {

    RecyclerView recyclerView;
    MaterialButton selectBtn;
    TextView groupName;
    ImageView arrowStatus;
    LinearLayout groupCard;
    boolean status = false;
    int clickedCount = 0;
    private int originalButtonColor;

    public ParentViewHolder(@NonNull View itemView) {
        super(itemView);

        groupName=itemView.findViewById(R.id.groupName);
        arrowStatus=itemView.findViewById(R.id.groupStatusArrow);
        groupCard=itemView.findViewById(R.id.groupCard);
        recyclerView=itemView.findViewById(R.id.parentRecyclerView);
        selectBtn=itemView.findViewById(R.id.selectBtn);
        originalButtonColor = selectBtn.getBackgroundTintList().getDefaultColor();
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
        selectBtn.setVisibility(View.VISIBLE);
        arrowStatus.setImageResource(R.drawable.arrow_up);

        status=true;
    }

    public void collapseGroup(){
        recyclerView.setVisibility(View.GONE);
        selectBtn.setVisibility(View.GONE);
        arrowStatus.setImageResource(R.drawable.arrow_down);

        status=false;
    }

    public void clickedOnce(){
        selectBtn.setBackgroundColor(itemView.getResources().getColor(R.color.grey));
        clickedCount = 1;
        updateButtonText();
    }

    private void updateButtonText() {
        if (clickedCount == 0) {
            selectBtn.setText("Select All");
            selectBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#006257")));
        } else {
            if (clickedCount % 2 == 0) {
                // Set the button color for "Remove All" to #8596A0
                selectBtn.setText("Remove All");
                selectBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8596A0")));
            } else {
                // Set the button color for "Remove All" to #8596A0
                selectBtn.setText("Remove All");
                selectBtn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#8596A0")));
            }
        }
    }
}
