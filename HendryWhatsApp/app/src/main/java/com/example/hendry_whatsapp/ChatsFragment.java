package com.example.hendry_whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.hendry_whatsapp.Model.DataModel.GroupData;
import com.example.hendry_whatsapp.Model.Interface.TaskCallback;
import com.example.hendry_whatsapp.ViewModel.ApiViewModel;
import com.example.hendry_whatsapp.databinding.FragmentChatsBinding;

import java.util.List;

public class ChatsFragment extends Fragment {

    private FragmentChatsBinding xml;
    private ParentAdapter parentAdapter;

    private ApiViewModel apiViewModel;

    public ChatsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        xml = FragmentChatsBinding.inflate(getLayoutInflater());

        //init
        apiViewModel = new ViewModelProvider(this).get(ApiViewModel.class);
        apiViewModel.fetchData(new TaskCallback() {
            @Override
            public void onSuccess(List<GroupData> list) {
                setAdapter(list);
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(getContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        return xml.getRoot();
    }

    private void setAdapter(List<GroupData> aar){
        parentAdapter = new ParentAdapter(getContext(), aar);
        xml.parentRecyclerview.setAdapter(parentAdapter);
        xml.parentRecyclerview.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    }
}