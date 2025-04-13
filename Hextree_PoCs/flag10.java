package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag10Binding;

public class flag10 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Intent recivedIntent = new Intent();
        String flag = recivedIntent.getStringExtra("flag");


        Log.d("EXPLOIT", "Stolen Flag: " + flag);
        Toast.makeText(this, "Flag: " + flag, Toast.LENGTH_LONG).show();

        finish(); // Close the activity immediately
    }


}