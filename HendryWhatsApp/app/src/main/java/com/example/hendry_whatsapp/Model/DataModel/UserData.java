package com.example.hendry_whatsapp.Model.DataModel;

import java.util.List;

public class UserData {
    private String user_id;
    private String online_for_shop;
    private String name;
    private String first_name;
    private String last_name;
    private String user_name;
    private List<OrderDetail> order_detail;

    public UserData() {
    }

    public UserData(String user_id, String online_for_shop, String name, String first_name, String last_name, String user_name, List<OrderDetail> order_detail) {
        this.user_id = user_id;
        this.online_for_shop = online_for_shop;
        this.name = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.user_name = user_name;
        this.order_detail = order_detail;
    }

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

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public List<OrderDetail> getOrder_detail() {
        return order_detail;
    }

    public void setOrder_detail(List<OrderDetail> order_detail) {
        this.order_detail = order_detail;
    }

}


