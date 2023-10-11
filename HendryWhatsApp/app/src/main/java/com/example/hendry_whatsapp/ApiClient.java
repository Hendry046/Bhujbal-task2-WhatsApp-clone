package com.example.hendry_whatsapp;

import android.os.AsyncTask;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiClient {

    private static final String BASE_URL = "https://png.boru.in/TestingAdminPanel/api/testing-1";

    public interface ApiCallback {
        void onResponse(String result);
        void onError(String errorMessage);
    }

    public static void fetchData(ApiCallback callback) {
        new FetchDataAsyncTask(callback).execute();
    }

    private static class FetchDataAsyncTask extends AsyncTask<Void, Void, String> {
        private final ApiCallback callback;

        public FetchDataAsyncTask(ApiCallback callback) {
            this.callback = callback;
        }

        @Override
        protected String doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(BASE_URL)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                if (response.isSuccessful()) {
                    return response.body().string();
                } else {
                    return null;  // Handle non-successful response
                }
            } catch (IOException e) {
                return null;  // Handle network errors
            }
        }

        @Override
        protected void onPostExecute(String result) {
            if (callback != null) {
                if (result != null) {
                    callback.onResponse(result);
                } else {
                    callback.onError("Failed to fetch data");
                }
            }
        }
    }
}
