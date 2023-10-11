package com.example.hendry_whatsapp;
import com.google.gson.Gson;

public class JsonParser {

    public static YourDataModel parseData(String jsonString) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, YourDataModel.class);
    }
}
