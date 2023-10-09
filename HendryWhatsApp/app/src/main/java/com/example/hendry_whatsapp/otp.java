package com.example.hendry_whatsapp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.hendry_whatsapp.R;
import com.example.hendry_whatsapp.profile;
import com.example.hendry_whatsapp.register;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class otp extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        // Get the phone number from the Intent
        String phoneNumber = getIntent().getStringExtra("phoneNumber");

        // Get the country prefix from the Intent
        String countryPrefix = getIntent().getStringExtra("countryPrefix");

        // Assume you have a TextView in your layout with id textViewDisplayNumber
        TextView textViewDisplayNumber = findViewById(R.id.textViewDisplayNumber);

        // Assume you have a TextView in your layout with id textViewCountryPrefix
//        TextView textViewCountryPrefix = findViewById(R.id.textViewCountryPrefix);

        // Set the country prefix and phone number in the TextView
        String fullPhoneNumber = countryPrefix + " " + phoneNumber;
        textViewDisplayNumber.setText(fullPhoneNumber);

        // Set the country prefix in the TextView
//        textViewCountryPrefix.setText(countryPrefix);

        // Get the Next button
        Button btnNext2 = findViewById(R.id.btnNext2);

        TextView textView = findViewById(R.id.textView14);

        // Get the EditText for OTP
        EditText editTextPhone3 = findViewById(R.id.editTextPhone3);

        // Set a click listener for the Next button
        btnNext2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered OTP
                String enteredOtp = editTextPhone3.getText().toString().trim();

                // Check if OTP is not empty and is valid (6 digits)
                if (!enteredOtp.isEmpty() && isSixDigitOTP(enteredOtp)) {
                    // Set a flag in SharedPreferences indicating registration is complete
                    setRegistrationCompleteFlag();

                    // Proceed to the next activity
                    Intent intent = new Intent(otp.this, profile.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Show appropriate toast messages
                    if (enteredOtp.isEmpty()) {
                        // OTP is empty
                        Toast.makeText(otp.this, "Enter the OTP", Toast.LENGTH_SHORT).show();
                    } else {
                        // Invalid OTP (not 6 digits)
                        Toast.makeText(otp.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(otp.this, register.class);
                startActivity(intent);
                finish();
            }
        });
    }

    // Function to check if the entered string is a valid 6-digit OTP
    private boolean isSixDigitOTP(String otp) {
        // Validate OTP based on a simple pattern (6 digits)
        String otpPattern = "^[0-9]{6}$";
        return otp.matches(otpPattern);
    }

    // Function to set a flag in SharedPreferences indicating registration is complete
    private void setRegistrationCompleteFlag() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("registration_complete", true);
        editor.apply();
    }
}
