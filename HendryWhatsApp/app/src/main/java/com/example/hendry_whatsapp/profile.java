package com.example.hendry_whatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Get the EditText for the name
        EditText editTextTextPersonName = findViewById(R.id.editTextTextPersonName);

        // Get the Next button
        Button button = findViewById(R.id.btnNext3);

        // Set a click listener for the Next button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered name
                String enteredName = editTextTextPersonName.getText().toString().trim();

                // Check if the name is not empty
                if (!enteredName.isEmpty()) {
                    // Proceed to the next activity
                    Intent intent = new Intent(profile.this, home.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Show a toast message if the name is empty
                    Toast.makeText(profile.this, "Enter your name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
