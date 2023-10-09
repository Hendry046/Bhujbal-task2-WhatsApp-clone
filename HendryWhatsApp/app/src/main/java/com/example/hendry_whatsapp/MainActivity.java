package com.example.hendry_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Delay for 1000 milliseconds (1 second)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Assume you have a shared preferences instance
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                // Check if the registration is complete
                boolean registrationComplete = sharedPreferences.getBoolean("registration_complete", false);

                // Determine the destination activity
                Class<?> destinationActivity = registrationComplete ? home.class : welcome.class;

                // Create an intent for the destination activity
                Intent intent = new Intent(MainActivity.this, destinationActivity);

                // Start the destination activity and finish the current one
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
