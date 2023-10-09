package com.example.hendry_whatsapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        TextView textView = findViewById(R.id.textView3);
        Button agreeButton = findViewById(R.id.button);

        String fullText = "Read our Privacy Policy. Tap Agree and continue to\n                     accept the Terms of Services.";

        // Create a SpannableString to apply styles
        SpannableString spannableString = new SpannableString(fullText);

        // Find the starting index of "Privacy Policy" and "Terms of Services"
        int privacyPolicyStart = fullText.indexOf("Privacy Policy");
        int termsOfServicesStart = fullText.indexOf("Terms of Services");

        // Change the color of "Privacy Policy"
        ForegroundColorSpan privacyPolicyColorSpan = new ForegroundColorSpan(Color.BLUE);
        spannableString.setSpan(privacyPolicyColorSpan, privacyPolicyStart, privacyPolicyStart + "Privacy Policy".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Change the color of "Terms of Services"
        ForegroundColorSpan termsOfServicesColorSpan = new ForegroundColorSpan(Color.BLUE);
        spannableString.setSpan(termsOfServicesColorSpan, termsOfServicesStart, termsOfServicesStart + "Terms of Services".length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the SpannableString to the TextView
        textView.setText(spannableString);

        // Set click listener for the Agree button
        agreeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open a new activity here
                Intent intent = new Intent(welcome.this, register.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
