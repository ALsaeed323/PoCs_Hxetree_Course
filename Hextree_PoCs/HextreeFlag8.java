package com.android.zerohextree;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityHextreeFlag8Binding;

public class HextreeFlag8 extends AppCompatActivity {

    private static final int REQUEST_CODE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_hextree_flag8);

        Button StartFun =findViewById((R.id.start_fun_));
        StartFun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAttack();
            }
        });

    }
    private  void launchAttack(){

        Intent flag8Intent =new Intent();
        flag8Intent.setComponent(new ComponentName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag8Activity"));
        startActivityForResult(flag8Intent,REQUEST_CODE);

    }


}