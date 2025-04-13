package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag11Binding;

public class flag11 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // extract the flag from the received intent
        Intent recivedIntent =new Intent();
        recivedIntent.putExtra("token",1094795585);

        // return  the result and close the activity
        setResult(RESULT_OK,recivedIntent);
        finish();

    }



}