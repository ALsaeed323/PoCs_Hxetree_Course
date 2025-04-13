package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;



public class flag20 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent();
        intent.setAction("io.hextree.broadcast.GET_FLAG");
        intent.putExtra("give-flag", true);
        sendBroadcast(intent);
    }


}