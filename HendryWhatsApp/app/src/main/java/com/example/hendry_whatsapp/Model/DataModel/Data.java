package com.example.hendry_whatsapp.Model.DataModel;

import java.util.List;

public class Data {
    private String status;
    private String message;
    private List<GroupData> data;

    public Data() {
    }

    public Data(String status, String message, List<GroupData> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GroupData> getData() {
        return data;
    }

    public void setData(List<GroupData> data) {
        this.data = data;
    }
}

