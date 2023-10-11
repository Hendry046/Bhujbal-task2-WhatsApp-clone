package com.example.hendry_whatsapp;

import java.util.List;

public class YourDataModel {
    private String status;
    private String message;
    private List<YourGroupModel> data;

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

    public List<YourGroupModel> getData() {
        return data;
    }

    public void setData(List<YourGroupModel> data) {
        this.data = data;
    }
// Add getters and setters
}
