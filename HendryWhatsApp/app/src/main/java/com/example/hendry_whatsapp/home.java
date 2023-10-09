package com.example.hendry_whatsapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;  // Use androidx instead of android.support.v7
import androidx.appcompat.app.AlertDialog;  // Use androidx instead of android.support.v7
import androidx.appcompat.app.AppCompatActivity;  // Use androidx instead of android.support.v7
import androidx.appcompat.widget.Toolbar;  // Use androidx instead of android.support.v7
import androidx.viewpager.widget.ViewPager;  // Use androidx instead of android.support.v4
import com.google.android.material.tabs.TabLayout;  // Use com.google.android.material instead of android.support.design

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class home extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager myViewPager;
    private TabLayout myTabLayout;
    private TabsAccessorAdapter myTabsAccessorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("WhatsApp");

        myViewPager = findViewById(R.id.main_tabs_pager);
        myTabsAccessorAdapter = new TabsAccessorAdapter(getSupportFragmentManager());
        myViewPager.setAdapter(myTabsAccessorAdapter);

        myTabLayout = findViewById(R.id.hometabs);
        myTabLayout.setupWithViewPager(myViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:
                showLogoutDialog();
                return true;

            // Handle other menu item clicks if needed

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showLogoutDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log Out");
        builder.setMessage("Are you sure you want to log out?");
        builder.setPositiveButton("Log Out", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Clear session data
                clearSessionData();

                // Show a toast message
                Toast.makeText(home.this, "Logged out", Toast.LENGTH_SHORT).show();

                // Navigate to the welcome or login screen
                Intent intent = new Intent(home.this, register.class);
                startActivity(intent);
                finish();  // Close the current activity
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // User canceled the logout action
                dialog.dismiss();
            }
        });
        builder.show();
    }

    // Method to clear session data
    private void clearSessionData() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();  // Clear all data
        editor.apply();
    }

}
