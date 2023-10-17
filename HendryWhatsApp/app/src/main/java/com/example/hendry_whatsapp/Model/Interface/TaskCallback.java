package com.example.hendry_whatsapp.Model.Interface;

import com.example.hendry_whatsapp.Model.DataModel.GroupData;

import java.util.List;

public interface TaskCallback {
    void onSuccess(List<GroupData> list);
    void onFailure(String errorMessage);
}
