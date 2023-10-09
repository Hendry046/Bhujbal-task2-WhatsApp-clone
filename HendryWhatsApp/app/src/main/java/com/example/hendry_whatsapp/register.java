package com.example.hendry_whatsapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class register extends AppCompatActivity {

    private EditText editTextPhone;
    private EditText editTextPhone2;
    private Spinner countrySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize views
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextPhone2 = findViewById(R.id.editTextPhone2);
        countrySpinner = findViewById(R.id.countrySpinner);

        // Example list of country names (replace with your own data)
        String[] countries = {"India", "USA", "Canada", "Philippines"};

        // Create the custom adapter
        CustomArrayAdapter adapter = new CustomArrayAdapter(this, countries);

        // Set the adapter on the Spinner
        countrySpinner.setAdapter(adapter);

        // Set up OnItemSelectedListener for the Spinner
        countrySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Get the selected country
                String selectedCountry = (String) parentView.getItemAtPosition(position);

                // Set the corresponding prefix in editTextPhone2
                String prefix = getPrefixForCountry(selectedCountry);
                editTextPhone2.setText(prefix);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        Button btnNext = findViewById(R.id.btnNext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the entered phone number
                String phoneNumber = editTextPhone.getText().toString().trim();

                // Get the selected country
                String selectedCountry = (String) countrySpinner.getSelectedItem();

                // Validate the phone number
                if (isValidPhoneNumber(phoneNumber, selectedCountry)) {
                    // Inflate the custom dialog layout
                    View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null);

                    // Set the entered phone number and country prefix in the dialog
                    TextView tvPhoneNumber = dialogView.findViewById(R.id.tvPhoneNumber);
                    String countryPrefix = getPrefixForCountry(selectedCountry);
                    String fullPhoneNumber = countryPrefix + " " + phoneNumber;
                    tvPhoneNumber.setText(fullPhoneNumber);

                    // Build the AlertDialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(register.this);
                    builder.setView(dialogView);

                    // Create and show the dialog
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();

                    // Set actions for the "Edit" and "OK" buttons
                    Button btnEdit = dialogView.findViewById(R.id.btnEdit);
                    Button btnOk = dialogView.findViewById(R.id.btnOk);

                    btnEdit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Handle the "Edit" button click (if needed)
                            alertDialog.dismiss(); // Close the dialog
                        }
                    });

                    btnOk.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            alertDialog.dismiss(); // Close the dialog

                            // Start the new activity and pass both phoneNumber and countryPrefix
                            Intent intent = new Intent(register.this, otp.class);
                            intent.putExtra("phoneNumber", phoneNumber);
                            intent.putExtra("countryPrefix", getPrefixForCountry(selectedCountry));
                            startActivity(intent);
                            finish();
                        }
                    });

                } else {
                    // Show a toast message for invalid phone number
                    Toast.makeText(register.this, "Invalid phone number for " + selectedCountry, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private String getPrefixForCountry(String country) {
        // Add more cases as needed
        switch (country) {
            case "India":
                return "+91";
            case "USA":
                return "+1";
            case "Canada":
                return "+1"; // Adjust based on the actual country code
            case "Philippines":
                return "+63";
            // Add more countries as needed
            default:
                return "";
        }
    }

    private boolean isValidPhoneNumber(String phoneNumber, String selectedCountry) {
        // Validate phone number based on a simple pattern (adjust as needed)
        String phonePattern = "^[0-9]{10}$";  // Default pattern for countries not explicitly handled

        // Override pattern for specific countries
        switch (selectedCountry) {
            case "India":
                phonePattern = "^[0-9]{10}$";
                break;
            case "USA":
            case "Canada":
                phonePattern = "^[0-9]{7}$";
                break;
            case "Philippines":
                phonePattern = "^[0-9]{10}$";
                break;
            // Add more countries as needed
        }

        // Validate phone number length and pattern
        return phoneNumber.matches(phonePattern);
    }
}
