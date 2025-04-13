package com.android.zerohextree;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag21Binding;

public class flag21 extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityFlag21Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        BroadcastReceiver receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String flag = intent.getStringExtra("flag");
                Log.d("flag21", flag);
            }
        };
        registerReceiver(receiver, new IntentFilter("io.hextree.broadcast.GIVE_FLAG"), Context.RECEIVER_EXPORTED);
    }



}