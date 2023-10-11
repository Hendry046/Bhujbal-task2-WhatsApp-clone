// ChatsFragment.java
package com.example.hendry_whatsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {

    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public ChatsFragment() {
        // Required empty public constructor
    }

    public static ChatsFragment newInstance(String param1, String param2) {
        ChatsFragment fragment = new ChatsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        orderAdapter = new OrderAdapter(getContext());
        recyclerView.setAdapter(orderAdapter);

        ApiClient.fetchData(new ApiClient.ApiCallback() {
            @Override
            public void onResponse(String jsonString) {
                if (jsonString != null) {
                    YourDataModel dataModel = JsonParser.parseData(jsonString);
                    if (dataModel != null && dataModel.getData() != null) {
                        List<YourOrderDetailModel> allOrders = new ArrayList<>();

                        for (YourGroupModel group : dataModel.getData()) {
                            for (YourUserDataModel userData : group.getGroup_data()) {
                                allOrders.addAll(userData.getOrder_detail());
                            }
                        }

                        orderAdapter.setOrders(allOrders);
                    }
                }
            }

            @Override
            public void onError(String errorMessage) {
                Toast.makeText(getContext(), "Failed to fetch data: " + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
