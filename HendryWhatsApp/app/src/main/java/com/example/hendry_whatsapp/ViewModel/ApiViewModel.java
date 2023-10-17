package com.example.hendry_whatsapp.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.hendry_whatsapp.Model.Interface.TaskCallback;
import com.example.hendry_whatsapp.Model.Repository.ApiRepo;

public class ApiViewModel extends AndroidViewModel {

    private ApiRepo apiRepo;

    public ApiViewModel(@NonNull Application application) {
        super(application);

        apiRepo = new ApiRepo(application);
    }

    public void fetchData(TaskCallback taskCallback){
        apiRepo.fetchData(taskCallback);
    }
}