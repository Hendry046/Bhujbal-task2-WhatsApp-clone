package com.example.hendry_whatsapp;

import java.util.List;

public class YourUserDataModel {
    private String user_id;
    private String online_for_shop;
    private String name;
    private List<YourOrderDetailModel> order_detail;

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getOnline_for_shop() {
        return online_for_shop;
    }

    public void setOnline_for_shop(String online_for_shop) {
        this.online_for_shop = online_for_shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<YourOrderDetailModel> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<YourOrderDetailModel> order_detail) {
        this.order_detail = order_detail;
    }
// Add getters and setters
}
