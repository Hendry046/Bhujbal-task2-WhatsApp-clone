package com.example.hendry_whatsapp;

import java.util.List;

public class YourGroupModel {
    private String group_id;
    private String group_name;
    private String count;
    private List<YourUserDataModel> group_data;

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public List<YourUserDataModel> getGroup_data() {
        return group_data;
    }

    public void setGroup_data(List<YourUserDataModel> group_data) {
        this.group_data = group_data;
    }
// Add getters and setters
}

