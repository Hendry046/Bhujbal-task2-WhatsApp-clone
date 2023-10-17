package com.example.hendry_whatsapp.Model.Repository;
import android.app.Application;

import com.example.hendry_whatsapp.Model.DataModel.Data;
import com.example.hendry_whatsapp.Model.Interface.ApiService;
import com.example.hendry_whatsapp.Model.Interface.TaskCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRepo {

    private Application application;
    private Data data;

    public ApiRepo(Application application) {
        this.application = application;
    }

    public void fetchData(TaskCallback taskCallback){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://png.boru.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<Data> call = apiService.fetchData();
        call.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if (response.isSuccessful()) {
                    data = response.body();
                    // Process the data here
                    taskCallback.onSuccess(data.getData());

                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                // Handle network failure
                taskCallback.onFailure(t.getMessage().toString());
            }
        });
    }
}
